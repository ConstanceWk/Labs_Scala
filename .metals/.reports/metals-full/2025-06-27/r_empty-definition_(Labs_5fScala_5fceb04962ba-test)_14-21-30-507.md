error id: file://<WORKSPACE>/lab6_unit/src/test/scala/25_UserContractSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/25_UserContractSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -org/scalatest/flatspec/AnyFlatSpec#
	 -org/mockito/Mockito.AnyFlatSpec#
	 -AnyFlatSpec#
	 -scala/Predef.AnyFlatSpec#
offset: 267
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/25_UserContractSpec.scala
text:
```scala
// src/test/scala/15_CalculatorrSpySpec.scala
package calcclass

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._

class CalculatorrSpySpec extends AnyFl@@atSpec with Matchers with MockitoSugar {

  "Calculatorr" should "track calls via mock" in {
    val calc = mock[Calculatorr]

    when(calc.add(1, 2)).thenReturn(3)
    when(calc.subtract(4, 2)).thenReturn(2)

    calc.add(1, 2) should be (3)
    calc.subtract(4, 2) should be (2)

    verify(calc).add(1, 2)
    verify(calc).subtract(4, 2)
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.