import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks._

class EmailValidatorSpec extends AnyFlatSpec with Matchers:

  val testCases = Table(
    ("input", "expected"),
    ("valid@email.com", true),
    ("invalid-email", false),
    ("", false),
    ("@domain.com", false),
    ("user@.com", false),
    ("user.name@domain.com", true),
    ("user@domain.co.uk", true)
  )

  forAll(testCases) { (input, expected) =>
    EmailValidator.isValid(input) should be(expected)
  }
