error id: file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -org/mockito/Mockito.
	 -org/mockito/Mockito#
	 -org/mockito/Mockito().
	 -org/mockito/ArgumentMatchers.
	 -org/mockito/ArgumentMatchers#
	 -org/mockito/ArgumentMatchers().
	 -.
	 -#
	 -().
	 -scala/Predef.
	 -scala/Predef#
	 -scala/Predef().
offset: 808
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.scalatestplus.mockito.MockitoSugar

// Classes à mocker (exemples)
case class User(id: Long, name: String)

trait UserRepository {
  def delete(id: Long): Unit
}

class UserService(userRepository: UserRepository) {
  def deleteUser(id: Long): Unit = userRepository.delete(id)
}

class UserServiceSpec extends AnyWordSpec with Matchers with MockitoSugar {

  "UserService.deleteUser" should {
    "call repository's delete method with correct ID" in {
      // Arrange
      val mockRepo = mock[UserRepository]
      val service = new UserService(mockRepo)

      // Act
      service.deleteUser(1L)

      // Assert
      verify(mockRepo).del@@ete(1L)
      verify(mockRepo, times(1)).delete(anyLong())
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.