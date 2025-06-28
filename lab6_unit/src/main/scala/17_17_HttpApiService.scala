package httpapi

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.circe._
import io.circe.generic.auto._
import io.circe.syntax._

case class Userr(id: Long, name: String)

object HttpApiService {
  val userRoutes = HttpRoutes.of[IO] {
    case GET -> Root / "user" / LongVar(id) =>
      Ok(Userr(id, "Alice").asJson)
  }

  val httpApp: HttpApp[IO] = userRoutes.orNotFound
}
