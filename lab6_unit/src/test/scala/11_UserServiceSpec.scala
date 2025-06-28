import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito
import org.mockito.Mockito.{verify, times}

class UserServiceSpec extends AnyWordSpec with Matchers {

  // Création du mock "à la main" avec classOf (pas de MockitoSugar)
  val mockRepo: UserRepository = Mockito.mock(classOf[UserRepository])
  val service = new UserService(mockRepo)

  "UserService.deleteUser" should {
    "call delete on the repository" in {
      service.deleteUser(1L)
      verify(mockRepo).delete(1L)
      verify(mockRepo, times(1)).delete(anyLong())
    }
  }

  "UserService.getUser" should {
    "return user from mocked repository" in {
      val user = User(1L, "Alice", "obligatoirepourex16@gmail.com")
      when(mockRepo.findById(1L)).thenReturn(Some(user))

      service.getUser(1L) should be(Some(user))
    }
  }
}
