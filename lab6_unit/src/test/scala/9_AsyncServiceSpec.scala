import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class AsyncServiceSpec extends AsyncFlatSpec with Matchers:

  "AsyncService" should "handle futures" in {
    val future = AsyncService.processData("test")
    future.map(_ should be("processed: test"))
  }
