error id: file://<WORKSPACE>/Lab5/test/CalculatorSpec.scala:`<none>`.
file://<WORKSPACE>/Lab5/test/CalculatorSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 254
uri: file://<WORKSPACE>/Lab5/test/CalculatorSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers {
  "A Calculator" should "add two numbers" in {
    val result = Calculator().add(2, 3)
    result should be(@@9)
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.