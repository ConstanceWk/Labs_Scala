error id: file://<WORKSPACE>/lab6_unit/src/test/scala/23_UserBuilderSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/23_UserBuilderSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 507
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/23_UserBuilderSpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class UserBuilderSpec extends AnyWordSpec with Matchers {
  "UserBuilder" should {
    "create a user with custom name and age" in {
      val user = UserBuilder()
        .withName("Alice")
        .withAge(25)
        .build()

      user.name shouldBe "Alice"
      user.age shouldBe 25
    }

    "create a user with default values" in {
      val user = UserBuilder().build()
      user.name shouldBe "DefaultName@@"
      user.age shouldBe 0
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.