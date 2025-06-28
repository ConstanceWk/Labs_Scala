error id: file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala:deleteUser.
file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala
empty definition using pc, found symbol in pc: deleteUser.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -org/mockito/Mockito.service.deleteUser.
	 -org/mockito/Mockito.service.deleteUser#
	 -org/mockito/Mockito.service.deleteUser().
	 -org/mockito/ArgumentMatchers.service.deleteUser.
	 -org/mockito/ArgumentMatchers.service.deleteUser#
	 -org/mockito/ArgumentMatchers.service.deleteUser().
	 -main/service/deleteUser.
	 -main/service/deleteUser#
	 -main/service/deleteUser().
	 -service/deleteUser.
	 -service/deleteUser#
	 -service/deleteUser().
	 -scala/Predef.service.deleteUser.
	 -scala/Predef.service.deleteUser#
	 -scala/Predef.service.deleteUser().
offset: 501
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/12_UserServiceSpec.scala
text:
```scala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.scalatestplus.mockito.MockitoSugar

import main._  

class UserServiceSpec extends AnyWordSpec with Matchers with MockitoSugar {

  "UserService.deleteUser" should {
    "call repository's delete method with correct ID" in {
      val mockRepo = mock[UserRepository]
      val service = new UserService(mockRepo)

      service.deleteU@@ser(1L)

      verify(mockRepo).delete(1L)
      verify(mockRepo, times(1)).delete(anyLong())
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: deleteUser.