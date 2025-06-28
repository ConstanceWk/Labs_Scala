package contract

import sttp.client3._
import io.circe.generic.auto._
import io.circe.parser.decode

case class User(id: Int, name: String)

class UserClient(baseUrl: String) {
  def getUser(id: Int): Either[String, User] = {
    val backend = HttpURLConnectionBackend()
    val response = basicRequest
      .get(uri"$baseUrl/users/$id")
      .send(backend)

    decode[User](response.body.getOrElse("")).left.map(_.getMessage)
  }
}
