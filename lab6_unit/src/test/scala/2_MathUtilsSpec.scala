import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MathUtilsSpec extends AnyFlatSpec with Matchers:

  "MathUtils" should "calculate factorial correctly" in {
    MathUtils.factorial(0) should be (1)
    MathUtils.factorial(1) should be (1)
    MathUtils.factorial(5) should be (120)
  }

  it should "throw exception for negative numbers in factorial" in {
    an [IllegalArgumentException] should be thrownBy {
      MathUtils.factorial(-3)
    }
  }

  "MathUtils" should "calculate fibonacci correctly" in {
    MathUtils.fibonacci(0) should be (0)
    MathUtils.fibonacci(1) should be (1)
    MathUtils.fibonacci(6) should be (8)
  }

  "MathUtils" should "identify prime numbers" in {
    MathUtils.isPrime(2) should be (true)
    MathUtils.isPrime(3) should be (true)
    MathUtils.isPrime(4) should be (false)
    MathUtils.isPrime(13) should be (true)
    MathUtils.isPrime(1) should be (false)
  }
