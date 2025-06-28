error id: file://<WORKSPACE>/lab6_unit/src/main/scala/17_17_HttpApiService.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/main/scala/17_17_HttpApiService.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -cats/effect/HttpRoutes.
	 -org/http4s/HttpRoutes.
	 -org/http4s/dsl/io/HttpRoutes.
	 -org/http4s/implicits/HttpRoutes.
	 -org/http4s/server/blaze/HttpRoutes.
	 -org/http4s/circe/HttpRoutes.
	 -io/circe/generic/auto/HttpRoutes.
	 -io/circe/syntax/HttpRoutes.
	 -HttpRoutes.
	 -scala/Predef.HttpRoutes.
offset: 322
uri: file://<WORKSPACE>/lab6_unit/src/main/scala/17_17_HttpApiService.scala
text:
```scala
package httpapi

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze._
import org.http4s.circe._
import io.circe.generic.auto._
import io.circe.syntax._

case class User(id: Long, name: String)

object HttpApiService {
  val userRoutes = HttpRou@@tes.of[IO] {
    case GET -> Root / "user" / LongVar(id) =>
      Ok(User(id, "Alice").asJson)
  }

  val httpApp: HttpApp[IO] = userRoutes.orNotFound
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.