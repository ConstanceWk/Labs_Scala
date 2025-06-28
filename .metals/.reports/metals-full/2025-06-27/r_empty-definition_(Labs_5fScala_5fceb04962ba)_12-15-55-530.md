error id: file://<WORKSPACE>/lab6_unit/src/main/scala/16_UserDao.scala:scala/Long#
file://<WORKSPACE>/lab6_unit/src/main/scala/16_UserDao.scala
empty definition using pc, found symbol in pc: scala/Long#
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Long#
	 -scala/Predef.Long#
offset: 343
uri: file://<WORKSPACE>/lab6_unit/src/main/scala/16_UserDao.scala
text:
```scala
case class User(id: Long, name: String, email: String)

trait UserDao {
  def save(user: User): Unit
  def findById(id: Long): Option[User]
}

class InMemoryUserDao extends UserDao {
  private var users: Map[Long, User] = Map.empty

  override def save(user: User): Unit = {
    users += (user.id -> user)
  }

  override def findById(id: Long@@): Option[User] = {
    users.get(id)
  }

  def clear(): Unit = {
    users = Map.empty
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Long#