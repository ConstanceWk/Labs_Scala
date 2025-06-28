package httpapi

import cats.effect._
import cats.effect.unsafe.implicits.global
import munit.CatsEffectSuite
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.typelevel.ci.CIStringSyntax

class HttpApiIntegrationSpec extends CatsEffectSuite {

  val httpApp: HttpApp[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "user" / "1" =>
      Ok("""{"id":1,"name":"Alice"}""", Header.Raw(ci"Content-Type", "application/json"))
  }.orNotFound

  test("GET /user/1 should return 200") {
    val req = Request[IO](Method.GET, uri"/user/1")
    httpApp.run(req).flatMap { resp =>
      IO(assertEquals(resp.status, Status.Ok))
    }
  }

  test("GET /user/1 should return correct JSON") {
    val req = Request[IO](Method.GET, uri"/user/1")
    httpApp.run(req).flatMap { resp =>
      resp.as[String].map { body =>
        assertEquals(body, """{"id":1,"name":"Alice"}""")
      }
    }
  }
}
