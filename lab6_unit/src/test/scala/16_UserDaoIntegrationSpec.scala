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

  "UserDao" should "save and retrieve users" in {
    val user = User(1L, "Alice", "alice@test.com")
    userDao.save(user)
    userDao.findById(1L) should be(Some(user))
  }
}
