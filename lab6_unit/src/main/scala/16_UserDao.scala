trait UserDao {
  def save(user: User): Unit
  def findById(id: Long): Option[User]
}

class InMemoryUserDao extends UserDao {
  private var users: Map[Long, User] = Map.empty

  override def save(user: User): Unit = {
    users += (user.id -> user)
  }

  override def findById(id: Long): Option[User] = {
    users.get(id)
  }

  def clear(): Unit = {
    users = Map.empty
  }
}
