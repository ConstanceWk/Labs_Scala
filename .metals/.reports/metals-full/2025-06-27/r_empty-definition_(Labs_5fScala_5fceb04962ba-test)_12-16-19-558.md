error id: file://<WORKSPACE>/lab6_unit/src/test/scala/16_UserDaoIntegrationSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/16_UserDaoIntegrationSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 414
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/16_UserDaoIntegrationSpec.scala
text:
```scala
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserDaoIntegrationSpec extends AnyFlatSpec with Matchers with BeforeAndAfterEach {

  var userDao: InMemoryUserDao = _

  override def beforeEach(): Unit = {
    userDao = new InMemoryUserDao
  }

  override def afterEach(): Unit = {
    userDao.clear()
  }

  "UserDao" should "@@save and retrieve users" in {
    val user = User(1L, "Alice", "alice@test.com")
    userDao.save(user)
    userDao.findById(1L) should be(Some(user))
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.