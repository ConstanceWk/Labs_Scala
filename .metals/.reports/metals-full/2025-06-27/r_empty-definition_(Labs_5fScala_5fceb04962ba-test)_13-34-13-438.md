error id: file://<WORKSPACE>/lab6_unit/src/test/scala/22_EndToEndSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/22_EndToEndSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -sttp/client3/getResponse/code.
	 -io/circe/parser/getResponse/code.
	 -io/circe/generic/auto/getResponse/code.
	 -scala/concurrent/duration/getResponse/code.
	 -getResponse/code.
	 -scala/Predef.getResponse.code.
offset: 1560
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/22_EndToEndSpec.scala
text:
```scala
package integration

import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.testcontainers.containers.PostgreSQLContainer
import sttp.client3._
import io.circe.parser._
import io.circe.generic.auto._
import scala.concurrent.duration._
import scala.concurrent.Await

class EndToEndSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll {

  val container = new PostgreSQLContainer("postgres:15")
  container.start()

  override def beforeAll(): Unit = {
    // ici tu peux démarrer ton app avec config DB injectée
    System.setProperty("DB_URL", container.getJdbcUrl)
    System.setProperty("DB_USER", container.getUsername)
    System.setProperty("DB_PASSWORD", container.getPassword)

    // démarrer le serveur HTTP (si besoin)
    // MyApp.start()
  }

  override def afterAll(): Unit = {
    container.stop()
  }

  case class User(id: Int, name: String)

  "The full stack" should "create and retrieve a user" in {
    val backend = HttpURLConnectionBackend()

    // 1. Envoie une requête POST pour créer un utilisateur
    val createRequest = basicRequest
      .post(uri"http://localhost:8080/users")
      .body("""{"name": "Alice"}""")
      .contentType("application/json")

    val createResponse = createRequest.send(backend)
    createResponse.code.code shouldBe 201

    // 2. Récupère l’utilisateur créé
    val getRequest = basicRequest
      .get(uri"http://localhost:8080/users/1")

    val getResponse = getRequest.send(backend)
    getResponse.code@@.code shouldBe 200

    // 3. Vérifie le contenu
    val user = decode[User](getResponse.body.getOrElse("")) // using Circe
    user shouldBe Right(User(1, "Alice"))
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.