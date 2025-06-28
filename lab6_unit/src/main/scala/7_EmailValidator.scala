import scala.util.matching.Regex

object EmailValidator:
  private val emailRegex: Regex =
    "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$".r

  def isValid(email: String): Boolean =
    emailRegex.matches(email)
