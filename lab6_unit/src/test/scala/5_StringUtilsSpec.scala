import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec

class StringUtilsPropertySpec extends AnyPropSpec with ScalaCheckPropertyChecks with Matchers:

  property("reversing twice gives original") {
    forAll { (s: String) =>
      StringUtils.reverse(StringUtils.reverse(s)) should be(s)
    }
  }

  property("concatenation length equals sum of lengths") {
    forAll { (a: String, b: String) =>
      StringUtils.length(StringUtils.concat(a, b)) should be(a.length + b.length)
    }
  }

  property("reversing concatenation equals reversed parts in reverse order") {
    forAll { (a: String, b: String) =>
      StringUtils.reverse(StringUtils.concat(a, b)) should be(StringUtils.reverse(b) + StringUtils.reverse(a))
    }
  }
