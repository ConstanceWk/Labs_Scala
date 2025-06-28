error id: file://<WORKSPACE>/lab6_unit/src/test/scala/5_StringUtilsSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/5_StringUtilsSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -StringUtils.
	 -scala/Predef.StringUtils.
offset: 730
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/5_StringUtilsSpec.scala
text:
```scala
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
      StringUtils.reverse(@@StringUtils.concat(a, b)) should be(StringUtils.reverse(b) + StringUtils.reverse(a))
    }
  }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.