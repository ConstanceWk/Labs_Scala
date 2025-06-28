import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonSpec extends AnyFlatSpec with Matchers {
  
  // ========================================================================
  // Custom Matchers définis comme méthodes simples
  // ========================================================================
  
  def beAdult(person: Person): Boolean = person.isAdult
  def haveValidEmail(person: Person): Boolean = person.hasValidEmail
  
  // ========================================================================
  // Tests avec une syntaxe qui fonctionne
  // ========================================================================
  
  val adultPerson = Person("Alice", 25, "alice@example.com")
  val minorPerson = Person("Bob", 16, "bob@school.edu")
  val invalidEmailPerson = Person("Charlie", 30, "invalid-email")
  val validStudent = Person("Diana", 20, "diana@university.edu")
  
  "Person" should "be identified as adult correctly" in {
    // Version qui fonctionne : utilise les fonctions custom
    beAdult(adultPerson) should be(true)
    beAdult(validStudent) should be(true)
    beAdult(minorPerson) should be(false)
  }
  
  it should "have valid email validation" in {
    haveValidEmail(adultPerson) should be(true)
    haveValidEmail(validStudent) should be(true)
    haveValidEmail(invalidEmailPerson) should be(false)
  }
  
  it should "combine validations elegantly" in {
    val perfectCandidate = Person("Eve", 28, "eve@company.com")
    
    beAdult(perfectCandidate) should be(true)
    haveValidEmail(perfectCandidate) should be(true)
  }
  
  it should "provide meaningful validation messages" in {
    // Tests avec messages d'erreur personnalisés
    val youngPerson = Person("Young", 17, "young@test.com")
    val badEmailPerson = Person("Bad", 25, "bademail")
    
    withClue(s"${youngPerson.name} should not be adult at age ${youngPerson.age}") {
      beAdult(youngPerson) should be(false)
    }
    
    withClue(s"${badEmailPerson.name} should not have valid email: ${badEmailPerson.email}") {
      haveValidEmail(badEmailPerson) should be(false)
    }
  }
}
