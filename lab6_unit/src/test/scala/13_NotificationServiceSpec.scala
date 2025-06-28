import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito.{verify, times}

// Démo de Mocking : vérifier une interaction
// Démo de Stubbing : simuler un retour d’état
class NotificationServiceSpec extends AnyWordSpec with Matchers {

  "Mocking behavior" should {
    "verify that send was called with the correct arguments" in {
      val mockEmailService = mock(classOf[EmailService])
      val service = new NotificationService(mockEmailService)

      service.notifyUser("bob@example.com", "Hi Bob!")

      verify(mockEmailService).send("bob@example.com", "Hi Bob!")
      verify(mockEmailService, times(1)).send(anyString(), anyString())
    }
  }

  "Stubbing behavior" should {
    "return stubbed lastRecipient value" in {
      val stubEmailService = new EmailService {
        private var last: Option[String] = None

        override def send(to: String, content: String): Unit = {
          last = Some(to) // ici on simule un état interne
        }

        override def lastRecipient: Option[String] = last
      }

      val service = new NotificationService(stubEmailService)
      service.notifyUser("alice@example.com", "Hello Alice!")

      service.lastNotifiedUser shouldBe Some("alice@example.com")
    }
  }
}
