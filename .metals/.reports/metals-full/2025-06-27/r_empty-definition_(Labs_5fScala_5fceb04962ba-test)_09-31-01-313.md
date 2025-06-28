error id: file://<WORKSPACE>/lab6_unit/src/test/scala/1_CalculatorSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/1_CalculatorSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 687
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/1_CalculatorSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers:

  "Calculator" should "add numbers correctly" in {
    Calculator.add(2, 3) should be (5)
  }

  it should "subtract numbers correctly" in {
    Calculator.subtract(5, 3) should be (2)
  }

  it should "multiply numbers correctly" in {
    Calculator.multiply(4, 3) should be (12)
  }

  it should "divide numbers correctly" in {
    Calculator.divide(10, 2) should be (5)
  }

  it should "throw ArithmeticException when dividing by zero" in {
    an [ArithmeticException] should be thrownBy {
      Calculator.divide(10, 0)
    }
  }

  "d@@ivide" should "throw ArithmeticException for zero denominator" in {
    val exception = assertThrows[ArithmeticException] {
      Calculator.divide(10, 0)
    }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.