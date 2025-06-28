package service

import zio._
import zio.test._
import zio.test.Assertion._

object UserServiceZioSpec extends ZIOSpecDefault {

  val userLayer: ULayer[UserService] =
    ZLayer.succeed(new DummyUserService)

  def spec = suite("UserServiceZioSpec")(
    test("should process user data") {
      for {
        service <- ZIO.service[UserService]
        result  <- service.processUser("data")
      } yield assertTrue(result.isValid)
    }
  ).provideLayer(userLayer)
}
