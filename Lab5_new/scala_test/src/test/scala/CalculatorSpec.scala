import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers {
  
  val calculator = new Calculator()
  
  "Calculator" should "add numbers correctly" in {
    calculator.add(2, 3) should be(5)
    calculator.add(0, 5) should be(5)
    calculator.add(-2, 3) should be(1)
    calculator.add(-5, -3) should be(-8)
  }
  
  it should "subtract numbers correctly" in {
    calculator.subtract(5, 3) should be(2)
    calculator.subtract(3, 5) should be(-2)
    calculator.subtract(0, 5) should be(-5)
    calculator.subtract(-2, -3) should be(1)
  }
  
  it should "multiply numbers correctly" in {
    calculator.multiply(2, 3) should be(6)
    calculator.multiply(0, 5) should be(0)
    calculator.multiply(-2, 3) should be(-6)
    calculator.multiply(-2, -3) should be(6)
  }
  
  it should "divide numbers correctly" in {
    calculator.divide(6, 3) should be(2.0)
    calculator.divide(5, 2) should be(2.5)
    calculator.divide(-6, 3) should be(-2.0)
    calculator.divide(-6, -3) should be(2.0)
  }
  
  it should "throw exception when dividing by zero" in {
    assertThrows[IllegalArgumentException] {
      calculator.divide(5, 0)
    }
  }
}
