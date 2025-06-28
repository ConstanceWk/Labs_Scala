package integration

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock._
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.io.Source
import java.net.HttpURLConnection
import java.net.URL

class ExternalApiSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll {

  val wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8089))

  override def beforeAll(): Unit = {
    wireMockServer.start()
    configureFor("localhost", 8089)

    stubFor(get(urlEqualTo("/api/users/1"))
      .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBody("""{"id": 1, "name": "Alice"}""")
      )
    )
  }

  override def afterAll(): Unit = {
    wireMockServer.stop()
  }

  "External API" should "return mocked user response" in {
    val url = new URL("http://localhost:8089/api/users/1")
    val connection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("GET")

    val body = Source.fromInputStream(connection.getInputStream).mkString
    connection.getResponseCode shouldBe 200
    body should include("Alice")
  }
}
