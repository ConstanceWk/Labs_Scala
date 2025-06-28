import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class UserBuilderSpec extends AnyWordSpec with Matchers {
  "UserBuilder" should {
    "create a user with custom name and age" in {
      val user = new UserBuilder()
        .withName("Alice")
        .withId(123)
        .withAge(25)
        .build()

      user.name shouldBe "Alice"
      user.age shouldBe 25
    }

    "create a user with default values" in {
      val user = new UserBuilder().build()
      user.name shouldBe "DefaultName"
      user.age shouldBe 0
    }
  }
}
