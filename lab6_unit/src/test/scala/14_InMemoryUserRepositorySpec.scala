import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class InMemoryUserRepositorySpec extends AnyWordSpec with Matchers {

  "InMemoryUserRepository" should {
    "save and retrieve a user" in {
      val repo = new InMemoryUserRepository
      val user = User(6L, "Charlie", "obligatoirepourex16@gmail.com")

      repo.save(user)
      repo.findById(6L) shouldBe Some(user)
    }

    "delete a user" in {
      val repo = new InMemoryUserRepository
      val user = User(42L, "Zelda", "obligatoirepourex16@gmail.com")

      repo.save(user)
      repo.delete(42L)
      repo.findById(42L) shouldBe None
    }
  }
}
