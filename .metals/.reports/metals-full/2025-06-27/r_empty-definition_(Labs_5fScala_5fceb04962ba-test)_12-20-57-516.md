error id: file://<WORKSPACE>/lab6_unit/src/test/scala/17_HttpApiIntegrationSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/17_HttpApiIntegrationSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -org/http4s/req.
	 -org/http4s/req#
	 -org/http4s/req().
	 -org/http4s/implicits/req.
	 -org/http4s/implicits/req#
	 -org/http4s/implicits/req().
	 -org/http4s/client/dsl/io/req.
	 -org/http4s/client/dsl/io/req#
	 -org/http4s/client/dsl/io/req().
	 -org/http4s/circe/req.
	 -org/http4s/circe/req#
	 -org/http4s/circe/req().
	 -io/circe/generic/auto/req.
	 -io/circe/generic/auto/req#
	 -io/circe/generic/auto/req().
	 -org/http4s/client/blaze/req.
	 -org/http4s/client/blaze/req#
	 -org/http4s/client/blaze/req().
	 -cats/effect/req.
	 -cats/effect/req#
	 -cats/effect/req().
	 -req.
	 -req#
	 -req().
	 -scala/Predef.req.
	 -scala/Predef.req#
	 -scala/Predef.req().
offset: 506
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/17_HttpApiIntegrationSpec.scala
text:
```scala
package httpapi

import munit.CatsEffectSuite
import org.http4s._
import org.http4s.implicits._
import org.http4s.client.dsl.io._
import org.http4s.circe._
import io.circe.generic.auto._
import org.http4s.client.Client
import org.http4s.client.middleware.Logger
import org.http4s.client.blaze._
import cats.effect._

class HttpApiIntegrationSpec extends CatsEffectSuite {

  test("GET /user/1 returns expected user") {
    val req = Request[IO](Method.GET, uri"/user/1")

    HttpApiService.httpApp.run(req@@).flatMap { res =>
      assertEquals(res.status, Status.Ok)
      res.as[User].map { user =>
        assertEquals(user, User(1L, "Alice"))
      }
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.