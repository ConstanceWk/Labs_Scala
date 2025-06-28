error id: file://<WORKSPACE>/lab6_unit/src/test/scala/15_CalculatorSpySpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/15_CalculatorSpySpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 563
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/15_CalculatorSpySpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.Mockito
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.spy

package calcclass

class CalculatorSpySpec extends AnyFlatSpec with Matchers {

  "A Calculator spy" should "delegate to the real implementation and verify method call" in {
    val calculator = spy(new Calculator)

    val result = calculator.add(2, 3)

    result should be(5)

    verify(calculator).add(2, 3)
  }

  it should "allow stubbin@@g methods" in {
    val calculator = spy(new Calculator)

    when(calculator.multiply(anyInt(), anyInt())).thenReturn(42)

    val result = calculator.multiply(7, 6)

    result should be(42)

    verify(calculator).multiply(7, 6)
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.