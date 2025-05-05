error id: scala/Predef.String#
file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
empty definition using pc, found symbol in pc: scala/Predef.String#
semanticdb not found
empty definition using fallback
non-local guesses:
	 -String#
	 -scala/Predef.String#
offset: 4145
uri: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
text:
```scala
package Lab3
/* ------------------------------------ Part 1 - Classes ------------------------------------ */

// 1. Create a simple Person class with firstName and lastName as constructor parameters.
// 2. Extend the Person class to include an age field with a default value of 0. Make sure the field can be modified after instantiation.

class Person(val firstName: String, val lastName: String, var age: Int = 0):
    // 4. Add a method to get the full name of the person.
    def fullName: String = s"$firstName $lastName"

@main def runApp(): Unit =
    val p = Person("Alice", "Martin")
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
) extends Person(firstName, lastName)


// 9. Design a Book class with title, author, and isbn fields. Add a method to format the book information as a string. 

class Book(val title: String, val author: String, val isbn: String):
  def format: String = s"$title by $author (ISBN: $isbn)"


// 10. CreateaBankAccountclasswithbalanceandmethodsdeposit,withdraw, and currentBalance. Make sure withdrawals cannot make the balance negative.

class BankAccount(private var balance: Double):
  def deposit(amount: Double): Unit =
    if amount > 0 then balance += amount

  def withdraw(amount: Double): Unit =
    if amount > 0 && amount <= balance then balance -= amount

  def currentBalance: Double = balance


/* ------------------------------------ Part 2 - Objects and Companion Objects ------------------------------------ */

// 11. Create a companion object for the Person class with an apply method that takes firstName and lastName as parameters.

object Person:
    def apply(firstName: String, lastName: String): Person =
        new Person(firstName, lastName)
    // 12. Add a fromString factory method to the Person companion object that creates a Person from a ”firstName lastName” string.
    def fromString(full: String): Person =
        val parts = full.split(" ")
        new Person(parts(0), parts(1))

val p = Person("Pedro", "Lopez") 


// 13. Create a Logger object with a log method that prints messages to the console. Make the method accept any type using generics.

object Logger:
    def log[T](msg: T): Unit = println(s"[LOG] $msg")

// 14. Implement a MathUtils object with methods for common mathematical operations (factorial, fibonacci, etc.).

object MathUtils:
  def factorial(n: Int): Int =
    if n <= 1 then 1 else n * factorial(n - 1)

  def fibonacci(n: Int): Int =
    if n <= 1 then n else fibonacci(n - 1) + fibonacci(n - 2)

// 15. Create a Configuration object that reads configuration values from a file (simulate this with hardcoded values).

object Configuration:
    val appName = "EFREIApp"
    val version = "1.0.0"
    val maxConnections = 10

// 16. Design a StringUtils object with extension methods for String opera- tions (e.g., reverse, isPalindrome).

object StringUtils:
  extension (s: String)
    def reverseStr: Stri@@ng = s.reverse
    def isPalindrome: Boolean = s == s.reverse




@main def runApp2(): Unit =
    println(s"Nom complet de Pedro: ${p.fullName}") 
    p.age = 25
    println(s"Age de base de Pedro: ${p.age}")  

    Logger.log("Hello")
    Logger.log(42)



```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Predef.String#