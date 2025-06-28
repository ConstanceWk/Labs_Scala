error id: file://<WORKSPACE>/lab6_unit/src/test/scala/24_UserServiceZioSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/24_UserServiceZioSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -zio/service/processUser.
	 -zio/service/processUser#
	 -zio/service/processUser().
	 -zio/test/service/processUser.
	 -zio/test/service/processUser#
	 -zio/test/service/processUser().
	 -zio/test/Assertion.service.processUser.
	 -zio/test/Assertion.service.processUser#
	 -zio/test/Assertion.service.processUser().
	 -service/processUser.
	 -service/processUser#
	 -service/processUser().
	 -scala/Predef.service.processUser.
	 -scala/Predef.service.processUser#
	 -scala/Predef.service.processUser().
offset: 641
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/24_UserServiceZioSpec.scala
text:
```scala
import zio._
import zio.test._
import zio.test.Assertion._

trait UserService:
  def processUser(data: String): UIO[ValidationResult]

case class ValidationResult(isValid: Boolean)

class DummyUserService extends UserService:
  def processUser(data: String): UIO[ValidationResult] =
    ZIO.succeed(ValidationResult(data.nonEmpty))

object UserServiceZioSpec extends ZIOSpecDefault {

  val userLayer: ULayer[UserService] =
    ZLayer.succeed(new DummyUserService)

  def spec = suite("UserServiceZioSpec")(
    test("should process user data") {
      for {
        service <- ZIO.service[UserService]
        result  <- service.processUser@@("data")
      } yield assertTrue(result.isValid)
    }
  ).provideLayer(userLayer)
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.