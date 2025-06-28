package calcclass

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.scalatestplus.mockito.MockitoSugar

class CalculatorSpySpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "Calculator" should "track calls via spy" in {
    val calc = spy(new Calculator)

    calc.add(1, 2) should be (3)
    verify(calc).add(1, 2)

    calc.subtract(4, 2) should be (2)
    verify(calc).subtract(4, 2)
  }
}
