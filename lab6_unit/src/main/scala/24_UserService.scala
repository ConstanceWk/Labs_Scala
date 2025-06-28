package service

import zio._

trait UserService {
  def processUser(data: String): UIO[ValidationResult]
}

case class ValidationResult(isValid: Boolean)

class DummyUserService extends UserService {
  def processUser(data: String): UIO[ValidationResult] =
    ZIO.succeed(ValidationResult(data.nonEmpty))
}
