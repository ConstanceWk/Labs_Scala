error id: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala:54
file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 2160
uri: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
text:
```scala
/* ------------------------------------ Part 1 - Classes ------------------------------------ */

// 1. Create a simple Person class with firstName and lastName as constructor parameters.
// 2. Extend the Person class to include an age field with a default value of 0. Make sure the field can be modified after instantiation.

class Personn(val firstName: String, val lastName: String, var age: Int = 0):
    // 4. Add a method to get the full name of the person.
    def fullName: String = s"$firstName $lastName"

@main def runApp(): Unit =
    val p = Personn("Alice", "Martin")
    println(s"Age de base de Alice: ${p.age}")      // 0
    p.age = 30
    println(s"Age après modif de Alice: ${p.age}")      // 30

// 3. Create a Car class with make, model, and year as constructor parameters. Make all fields read-only (vals).

class Car(val make: String, val model: String, val year: Int)

// 5. Create a Counter class with a private count field and methods increment, decrement, and current to manage the count.
class Counter:
    private var count: Int = 0

    def increment(): Unit = count += 1
    def decrement(): Unit = count -= 1
    def current: Int = count

// 6. Create a Point class with x and y coordinates. Override the toString method to provide a string representation of the point.

class Point(val x: Int, val y: Int):
    override def toString: String = s"($x,$y)"

// 7. Create a Rectangle class with width and height. Add a method to calculate the area of the rectangle.

class Rectangle(val topLeft: Point, val bottomRight: Point):
    def width: Int = bottomRight.x - topLeft.x
    def height: Int = bottomRight.y - topLeft.y
    def area: Int = width * height


// 8. create a student class that herists from Personn and adds a studentId field.
class Student(
    firstName: String,
    lastName: String,
    val studentId: String
) extends Personn(firstName, lastName)


// 9. Design a Book class with title, author, and isbn fields. Add a method to format the book information as a string. 

class Book(val title: String, val author: String, val isbn: String):
  def format: String = s"$title by $author (ISBN: $isbn)"


// 10. Cr@@eateaBankAccountclasswithbalanceandmethodsdeposit,withdraw, and currentBalance. Make sure withdrawals cannot make the balance negative.

```


#### Short summary: 

empty definition using pc, found symbol in pc: 