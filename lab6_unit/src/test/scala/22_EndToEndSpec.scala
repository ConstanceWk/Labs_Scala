package integration

import cats.effect._
import cats.effect.unsafe.implicits.global
import com.comcast.ip4s._
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import httpapi.HttpApiService

import java.util.concurrent.atomic.AtomicReference

import sttp.client3._

class EndToEndSpec extends AnyWordSpec with Matchers {

  val serverRef = new AtomicReference[Server]()

  "The full stack" should {
    "retrieve a user" in {
      val server = EmberServerBuilder
        .default[IO]
        .withHost(host"localhost")
        .withPort(port"8080")
        .withHttpApp(HttpApiService.httpApp)
        .build
        .use { s =>
          IO {
            serverRef.set(s)

            val backend = HttpURLConnectionBackend()
            val request = basicRequest
              .get(uri"http://localhost:8080/user/1")

            val response = request.send(backend)

            response.code.code shouldBe 200
            response.body.getOrElse("") should include ("Alice")
          }
        }
        .unsafeRunSync()
    }
  }
}
