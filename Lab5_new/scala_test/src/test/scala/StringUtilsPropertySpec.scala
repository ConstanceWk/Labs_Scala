import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck.Gen

class StringUtilsPropertySpec extends AnyFlatSpec with Matchers with ScalaCheckPropertyChecks {
  
  // ========================================================================
  // Property-Based Tests pour reverse
  // ========================================================================
  
  "StringUtils.reverse" should "satisfy the property: reversing twice gives original" in {
    // 🎯 PROPRIÉTÉ PRINCIPALE DE L'EXERCICE
    property("reversing twice gives original") {
      forAll { (s: String) =>
        StringUtils.reverse(StringUtils.reverse(s)) should be(s)
      }
    }
  }
  
  it should "preserve string length" in {
    property("reverse preserves length") {
      forAll { (s: String) =>
        StringUtils.reverse(s).length should be(s.length)
      }
    }
  }
  
  it should "handle empty string correctly" in {
    StringUtils.reverse("") should be("")
  }
  
  it should "be its own inverse" in {
    property("reverse is its own inverse") {
      forAll { (s: String) =>
        val reversed = StringUtils.reverse(s)
        StringUtils.reverse(reversed) should be(s)
      }
    }
  }
  
  // ========================================================================
  // Property-Based Tests pour concatenation
  // ========================================================================
  
  "StringUtils.concatenate" should "be associative" in {
    property("concatenation is associative") {
      forAll { (s1: String, s2: String, s3: String) =>
        StringUtils.concatenate(StringUtils.concatenate(s1, s2), s3) should be(
          StringUtils.concatenate(s1, StringUtils.concatenate(s2, s3))
        )
      }
    }
  }
  
  it should "have empty string as identity element" in {
    property("empty string is identity for concatenation") {
      forAll { (s: String) =>
        StringUtils.concatenate(s, "") should be(s)
        StringUtils.concatenate("", s) should be(s)
      }
    }
  }
  
  it should "preserve total length" in {
    property("concatenation length is sum of lengths") {
      forAll { (s1: String, s2: String) =>
        StringUtils.concatenate(s1, s2).length should be(s1.length + s2.length)
      }
    }
  }
  
  // ========================================================================
  // Property-Based Tests pour length
  // ========================================================================
  
  "StringUtils.length" should "always return non-negative values" in {
    property("length is always non-negative") {
      forAll { (s: String) =>
        StringUtils.length(s) should be >= 0
      }
    }
  }
  
  it should "return zero only for empty string" in {
    property("length is zero only for empty string") {
      forAll { (s: String) =>
        (StringUtils.length(s) == 0) should be(s.isEmpty)
      }
    }
  }
  
  // ========================================================================
  // Property-Based Tests avec générateurs personnalisés
  // ========================================================================
  
  "StringUtils with custom generators" should "work with non-empty strings" in {
    val nonEmptyStringGen = Gen.alphaStr.suchThat(_.nonEmpty)
    
    property("reverse of non-empty string is non-empty") {
      forAll(nonEmptyStringGen) { s =>
        StringUtils.reverse(s) should not be empty
        StringUtils.reverse(s).length should be > 0
      }
    }
  }
  
  it should "work with specific character sets" in {
    val alphaNumericGen = Gen.alphaNumStr
    
    property("operations work with alphanumeric strings") {
      forAll(alphaNumericGen) { s =>
        StringUtils.reverse(StringUtils.reverse(s)) should be(s)
        StringUtils.length(s) should be >= 0
      }
    }
  }
  
  it should "work with bounded string lengths" in {
    val boundedStringGen = Gen.choose(0, 100).flatMap(n => Gen.stringOfN(n, Gen.alphaChar))
    
    property("operations work correctly for strings of length 0-100") {
      forAll(boundedStringGen) { s =>
        s.length should be <= 100
        StringUtils.reverse(s).length should be(s.length)
        StringUtils.reverse(StringUtils.reverse(s)) should be(s)
      }
    }
  }
  
  // ========================================================================
  // Propriétés composées et relations entre opérations
  // ========================================================================
  
  "StringUtils operations" should "satisfy composition properties" in {
    property("reverse and concatenation interact correctly") {
      forAll { (s1: String, s2: String) =>
        // reverse(s1 + s2) == reverse(s2) + reverse(s1)
        StringUtils.reverse(StringUtils.concatenate(s1, s2)) should be(
          StringUtils.concatenate(StringUtils.reverse(s2), StringUtils.reverse(s1))
        )
      }
    }
  }
  
  it should "preserve character content" in {
    property("reverse preserves character content") {
      forAll { (s: String) =>
        val original = s.toSet
        val reversed = StringUtils.reverse(s).toSet
        original should be(reversed)
      }
    }
  }
  
  // ========================================================================
  // Tests de performance avec Property-Based Testing
  // ========================================================================
  
  "StringUtils performance" should "be efficient for reasonable string sizes" in {
    val reasonableStringGen = Gen.choose(0, 1000).flatMap(n => Gen.stringOfN(n, Gen.alphaChar))
    
    property("operations complete in reasonable time") {
      forAll(reasonableStringGen) { s =>
        val start = System.nanoTime()
        
        val reversed = StringUtils.reverse(s)
        val concatenated = StringUtils.concatenate(s, s)
        val length = StringUtils.length(s)
        
        val end = System.nanoTime()
        
        // Vérifications fonctionnelles
        reversed.length should be(s.length)
        concatenated.length should be(s.length * 2)
        length should be(s.length)
        
        // Vérification de performance (moins de 10ms pour 1000 caractères)
        (end - start) should be < 10000000L // 10ms en nanoseconds
      }
    }
  }
}