error id: file://<WORKSPACE>/Lab5/CalculatorSpec.scala:`<none>`.
file://<WORKSPACE>/Lab5/CalculatorSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -should.
	 -should#
	 -should().
	 -scala/Predef.should.
	 -scala/Predef.should#
	 -scala/Predef.should().
offset: 157
uri: file://<WORKSPACE>/Lab5/CalculatorSpec.scala
text:
```scala
class CalculatorSpec extends AnyFlatSpec with Matchers {
  "A Calculator" should "add two numbers" in {
    val result = Calculator().add(2, 3)
    result sh@@ould be(5)
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.