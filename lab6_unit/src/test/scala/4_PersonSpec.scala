import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.{MatchResult, Matcher}
import scala.util.matching.Regex

class PersonSpec extends AnyFlatSpec with Matchers:

  // ----- Custom Matchers -----

  def beAdult: Matcher[Person] = Matcher { person =>
    MatchResult(
      person.age >= 18,
      s"${person.name} is not an adult (age: ${person.age})",
      s"${person.name} is an adult"
    )
  }

  def haveValidEmail: Matcher[Person] = Matcher { person =>
    val emailRegex: Regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$".r
    MatchResult(
      emailRegex.matches(person.email),
      s"${person.email} is not a valid email address",
      s"${person.email} is a valid email address"
    )
  }

  // ----- Tests -----

  "A person" should "be considered adult if age >= 18" in {
    val alice = Person("Alice", 25, "alice@test.com")
    alice should beAdult
  }

  it should "not be considered adult if age < 18" in {
    val bob = Person("Bob", 15, "bob@test.com")
    bob should not be beAdult
  }

  it should "have a valid email if format is correct" in {
    val charlie = Person("Charlie", 30, "charlie@mail.org")
    charlie should haveValidEmail
  }

  it should "fail if email format is invalid" in {
    val invalid = Person("Invalid", 30, "invalid-email")
    invalid should not (haveValidEmail)
  }
