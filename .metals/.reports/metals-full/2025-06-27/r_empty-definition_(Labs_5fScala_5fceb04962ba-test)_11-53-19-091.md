error id: file://<WORKSPACE>/lab6_unit/src/test/scala/14_InMemoryUserRepositorySpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/14_InMemoryUserRepositorySpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -InMemoryUserRepository#
	 -scala/Predef.InMemoryUserRepository#
offset: 445
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/14_InMemoryUserRepositorySpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class InMemoryUserRepositorySpec extends AnyWordSpec with Matchers {

  "InMemoryUserRepository" should {
    "save and retrieve a user" in {
      val repo = new InMemoryUserRepository
      val user = User(6L, "Charlie")

      repo.save(user)
      repo.findById(6L) shouldBe Some(user)
    }

    "delete a user" in {
      val repo = new InMemoryUserR@@epository
      val user = User(42L, "Zelda")

      repo.save(user)
      repo.delete(42L)
      repo.findById(42L) shouldBe None
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.