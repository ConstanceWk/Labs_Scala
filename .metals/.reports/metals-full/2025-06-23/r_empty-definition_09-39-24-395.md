error id: file://<WORKSPACE>/Lab5/build.sbt:
file://<WORKSPACE>/Lab5/build.sbt
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 32
uri: file://<WORKSPACE>/Lab5/build.sbt
text:
```scala
libraryDependencies += "org.scal@@atest" %% "scalatest" % "3.2.15" % Test

class CalculatorSpec extends AnyFlatSpec with Matchers:
    "A Calculator" should "add two numbers" in {
        val result = Calculator().add(2, 3)
        result should be(5)
    }

```


#### Short summary: 

empty definition using pc, found symbol in pc: 