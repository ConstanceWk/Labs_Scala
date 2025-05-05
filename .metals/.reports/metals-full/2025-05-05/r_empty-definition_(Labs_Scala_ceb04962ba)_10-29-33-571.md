error id: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala:10
file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:
	 -age.
	 -age#
	 -age().
	 -scala/Predef.age.
	 -scala/Predef.age#
	 -scala/Predef.age().
offset: 556
uri: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
text:
```scala
/* ------------------------------------ Part 1 - Classes ------------------------------------ */

// 1. Create a simple Person class with firstName and lastName as constructor parameters.
// 2. Extend the Person class to include an age field with a default value of 0. Make sure the field can be modified after instantiation.

class Personn(val firstName: String, val lastName: String, var age: Int = 0)

// 3. Create a Car class with make, model, and year as constructor parameters. Make all fields read-only (vals).

val p = Personn("Alice", "Martin")
p.@@age = 30



```


#### Short summary: 

empty definition using pc, found symbol in pc: 