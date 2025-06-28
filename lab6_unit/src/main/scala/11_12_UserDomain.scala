case class User(id: Long, name: String, email: String)

trait UserRepository {
  def save(user: User): User
  def findById(id: Long): Option[User]
  def delete(id: Long): Unit
}

class UserService(val userRepository: UserRepository) {
  def deleteUser(id: Long): Unit = userRepository.delete(id)
  def getUser(id: Long): Option[User] = userRepository.findById(id)
}
