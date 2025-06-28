import scala.collection.mutable

class InMemoryUserRepository extends UserRepository {
  private val users = mutable.Map[Long, User]()

  override def save(user: User): User = {
    users(user.id) = user
    user
  }

  override def findById(id: Long): Option[User] = users.get(id)

  override def delete(id: Long): Unit = users.remove(id)
}
