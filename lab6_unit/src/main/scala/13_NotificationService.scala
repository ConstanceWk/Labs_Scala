trait EmailService {
  def send(to: String, content: String): Unit
  def lastRecipient: Option[String] // pour simuler un état (utile pour le stub)
}

class NotificationService(emailService: EmailService) {
  def notifyUser(to: String, message: String): Unit = {
    emailService.send(to, message)
  }

  def lastNotifiedUser: Option[String] = emailService.lastRecipient
}
