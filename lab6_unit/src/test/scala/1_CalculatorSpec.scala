package calcobject

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

  // exo 6
  "divide" should "throw ArithmeticException for zero denominator" in {
    val exception = assertThrows[ArithmeticException] {
      Calculator.divide(10, 0)
    }
  }
