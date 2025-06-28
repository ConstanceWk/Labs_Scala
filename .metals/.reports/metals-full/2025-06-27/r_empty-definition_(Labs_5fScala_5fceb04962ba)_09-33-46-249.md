error id: file://<WORKSPACE>/lab6_unit/src/main/scala/7_EmailValidator.scala:scala/Boolean#
file://<WORKSPACE>/lab6_unit/src/main/scala/7_EmailValidator.scala
empty definition using pc, found symbol in pc: scala/Boolean#
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Boolean#
	 -scala/Predef.Boolean#
offset: 166
uri: file://<WORKSPACE>/lab6_unit/src/main/scala/7_EmailValidator.scala
text:
```scala
import scala.util.matching.Regex

object EmailValidator:
  private val emailRegex: Regex =
    "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$".r

  def isValid(email: String): B@@oolean =
    emailRegex.matches(email)

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Boolean#