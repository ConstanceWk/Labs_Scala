error id: file://<WORKSPACE>/lab6_unit/src/test/scala/MathUtilsSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/MathUtilsSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -MathUtils.isPrime.
	 -MathUtils.isPrime#
	 -MathUtils.isPrime().
	 -scala/Predef.MathUtils.isPrime.
	 -scala/Predef.MathUtils.isPrime#
	 -scala/Predef.MathUtils.isPrime().
offset: 750
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/MathUtilsSpec.scala
text:
```scala
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
    MathUtils.i@@sPrime(2) should be (true)
    MathUtils.isPrime(3) should be (true)
    MathUtils.isPrime(4) should be (false)
    MathUtils.isPrime(13) should be (true)
    MathUtils.isPrime(1) should be (false)
  }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.