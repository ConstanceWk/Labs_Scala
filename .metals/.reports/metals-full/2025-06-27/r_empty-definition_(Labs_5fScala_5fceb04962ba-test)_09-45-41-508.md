error id: file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala:getUser.
file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala
empty definition using pc, found symbol in pc: getUser.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -service/getUser.
	 -service/getUser#
	 -service/getUser().
	 -scala/Predef.service.getUser.
	 -scala/Predef.service.getUser#
	 -scala/Predef.service.getUser().
offset: 510
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.MockitoSugar

class UserServiceSpec extends AnyWordSpec with Matchers with MockitoSugar {

  "UserService" should {
    "return user from mocked repository" in {
      // Arrange
      val mockRepo = mock[UserRepository]
      val user = User(1L, "Alice")
      when(mockRepo.findById(1L)).thenReturn(Some(user))

      val service = new UserService(mockRepo)

      // Act & Assert
      service.getUse@@r(1L) should be(Some(user))
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: getUser.