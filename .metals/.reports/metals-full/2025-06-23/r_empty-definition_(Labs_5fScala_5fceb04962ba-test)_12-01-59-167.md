error id: file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/PersonSpec.scala:`<none>`.
file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/PersonSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 801
uri: file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/PersonSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonSpec extends AnyFlatSpec with Matchers {
  
  val adultPerson = Person("Alice", 25, "alice@example.com")
  val minorPerson = Person("Bob", 16, "bob@school.edu")
  val invalidEmailPerson = Person("Charlie", 30, "invalid-email")
  val validStudent = Person("Diana", 20, "diana@university.edu")
  
  "Person" should "be identified as adult correctly" in {
    adultPerson.isAdult should be(true)
    validStudent.isAdult should be(true)
    minorPerson.isAdult should be(false)
  }
  
  it should "have valid email validation" in {
    adultPerson.hasValidEmail should be(true)
    validStudent.hasValidEmail should be(true)
    invalidEmailPerson.hasValidEmail should be(false)
  }
  
  it should "work@@ with age ranges" in {
    adultPerson.age should be >= 18
    validStudent.age should be >= 18
    minorPerson.age should be < 18
  }
  
  it should "validate email domains" in {
    adultPerson.email should include("@example.com")
    minorPerson.email should include("@school.edu")
    validStudent.email should include("@university.edu")
  }
  
  it should "handle edge cases" in {
    val exactlyAdult = Person("Dave", 18, "dave@test.com")
    val almostAdult = Person("Eve", 17, "eve@test.com")
    
    exactlyAdult.isAdult should be(true)
    almostAdult.isAdult should be(false)
    
    exactlyAdult.hasValidEmail should be(true)
  }
  
  it should "validate multiple properties together" in {
    val perfectCandidate = Person("Eve", 28, "eve@company.com")
    
    perfectCandidate.isAdult should be(true)
    perfectCandidate.hasValidEmail should be(true)
    perfectCandidate.age should be >= 25
    perfectCandidate.email should include("@company.com")
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.