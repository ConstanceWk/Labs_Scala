error id: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala:13
file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 592
uri: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
text:
```scala
/* ------------------------------------ Part 1 - Classes ------------------------------------ */

// 1. Create a simple Person class with firstName and lastName as constructor parameters.
// 2. Extend the Person class to include an age field with a default value of 0. Make sure the field can be modified after instantiation.

class Personn(val firstName: String, val lastName: String, var age: Int = 0)

@main def runApp(): Unit =
  val p = Personn("Alice", "Martin")
  println(s"Age de base de Alice: $p.age")      // 0
  p.age = 30
  println(p.age)      // 30

// 3. Create a Car class wit@@h make, model, and year as constructor parameters. Make all fields read-only (vals).





```


#### Short summary: 

empty definition using pc, found symbol in pc: 