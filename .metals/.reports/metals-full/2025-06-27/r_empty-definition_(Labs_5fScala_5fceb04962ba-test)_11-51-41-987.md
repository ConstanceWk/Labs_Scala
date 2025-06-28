error id: file://<WORKSPACE>/lab6_unit/src/test/scala/13_NotificationService.scala:scala/Option#
file://<WORKSPACE>/lab6_unit/src/test/scala/13_NotificationService.scala
empty definition using pc, found symbol in pc: scala/Option#
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Option#
	 -scala/Predef.Option#
offset: 331
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/13_NotificationService.scala
text:
```scala
trait EmailService {
  def send(to: String, content: String): Unit
  def lastRecipient: Option[String] // pour simuler un état (utile pour le stub)
}

class NotificationService(emailService: EmailService) {
  def notifyUser(to: String, message: String): Unit = {
    emailService.send(to, message)
  }

  def lastNotifiedUser: Opti@@on[String] = emailService.lastRecipient
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Option#