error id: file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -org/mockito/MockitoSugar.
	 -org/mockito/MockitoSugar#
	 -org/mockito/MockitoSugar().
	 -org/mockito/Mockito.MockitoSugar.
	 -org/mockito/Mockito.MockitoSugar#
	 -org/mockito/Mockito.MockitoSugar().
	 -MockitoSugar.
	 -MockitoSugar#
	 -MockitoSugar().
	 -scala/Predef.MockitoSugar.
	 -scala/Predef.MockitoSugar#
	 -scala/Predef.MockitoSugar().
offset: 116
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/11_UserServiceSpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.MockitoSu@@gar
import org.mockito.Mockito._

class UserServiceSpec extends AnyWordSpec with Matchers with MockitoSugar {

  "UserService" should {
    "return user from mocked repository" in {
      // Arrange
      val mockRepo = mock[UserRepository]
      val user = User(1L, "Alice")
      when(mockRepo.findById(1L)).thenReturn(Some(user))

      val service = new UserService(mockRepo)

      // Act & Assert
      service.getUser(1L) should be(Some(user))
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.