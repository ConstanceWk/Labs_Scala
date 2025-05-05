error id: file://<WORKSPACE>/Lab3/Lab3_Ex1.scala:380
file://<WORKSPACE>/Lab3/Lab3_Ex1.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 13250
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
        def reverseStr: String = s.reverse
        def isPalindrome: Boolean = s == s.reverse

// 17. Create a Email class with validation logic in its companion object. The companion should have an apply method that returns Option[Email] (None for invalid emails).

class Email private (val value: String)

object Email:
    def apply(input: String): Option[Email] =
        if input.contains("@") then Some(new Email(input))
        else None

// 18. Implement a IdGenerator singleton object that produces unique IDs (sim- ple counter implementation).

object IdGenerator:
    private var currentId = 0

    def nextId(): Int =
        currentId += 1
        currentId

// 19. Create a Circle class with radius and a companion object that provides constants like PI and factory methods like unitCircle.

class Circle(val radius: Double):
    def area: Double = Circle.PI * radius * radius

object Circle:
    val PI = 3.1415926535
    def unitCircle: Circle = new Circle(1.0)

// 20. Design a Database companion object that manages a collection of Person instances with methods to add, remove, and query persons.

object Database:
    import StringUtils.* 

    private var people: List[Person] = List()

    def add(person: Person): Unit =
        people = person :: people

    def remove(person: Person): Unit =
        people = people.filterNot(p => p.fullName == person.fullName)

    def findByName(name: String): List[Person] =
        people.filter(_.fullName.contains(name))


@main def RunApp2(): Unit =
  import StringUtils.*

  val p1 = Person("Alice", "Martin")
  val p2 = Person.fromString("Bob Dupont")
  Logger.log(p2.fullName)
  Logger.log(MathUtils.fibonacci(6))

  println("radar".isPalindrome) 

  Email("test@example.com") match
    case Some(email) => println("Email valide")
    case None => println("Email invalide")

  println(IdGenerator.nextId())
  println(IdGenerator.nextId())

  val c = Circle.unitCircle
  println(c.area)

  Database.add(p1)
  Database.add(p2)
  println(Database.findByName("Alice").map(_.fullName))


/* ------------------------------------ Part 3 - Case Classes and Their Companions ------------------------------------ */

// 21. Convert the Point class to a case class and demonstrate the automatically generated methods.

case class Point2(x: Int, y: Int)

val p1 = Point2(1, 2)
val p2 = p1.copy(x = 5)

// 22. Create a case class User with id, name, and email fields. Examine its companion object’s apply and unapply methods.

case class User(id: Int, name: String, email: String)

val u = User(1, "Alice", "alice@efrei.fr")

// 23. Implement a case class Transaction with id, amount, and timestamp. Add a custom toString method in the companion object.

case class Transaction(id: String, amount: Double, timestamp: Long)

object Transaction:
    def toString(t: Transaction): String =
        s"Transaction #${t.id} - ${t.amount}€ at ${t.timestamp}"

// 24. Create a case class ConfigEntry and its companion with a fromString parser method.

case class ConfigEntry(key: String, value: String)

object ConfigEntry:
    def fromString(line: String): Option[ConfigEntry] =
        line.split("=") match
        case Array(k, v) => Some(ConfigEntry(k.trim, v.trim))
        case _           => None

// 25. Design an ADT (Algebraic Data Type) using sealed case classes for a simple AST (Abstract Syntax Tree) of arithmetic expressions.

sealed trait Expr

case class Number(value: Int) extends Expr
case class Add(left: Expr, right: Expr) extends Expr
case class Sub(left: Expr, right: Expr) extends Expr


@main def runApp3(): Unit =
    println(p1)         // Point2(1,2)
    println(p2)         // Point2(5,2)
    println(p1 == p2)   // false
    u match {
        case User(id, name, email) =>
            println(s"Nom: $name, Email: $email")
        case _ => println("Aucun utilisateur trouvé.")
    }

    val t = Transaction("abc123", 99.99, 1714992954L)
    println(Transaction.toString(t))

    ConfigEntry.fromString("host = localhost") match
    case Some(entry) => println(entry)
    case None        => println("Erreur de format")

    def eval(expr: Expr): Int = expr match
        case Number(v)   => v
        case Add(l, r)   => eval(l) + eval(r)
        case Sub(l, r)   => eval(l) - eval(r)

    val e = Add(Number(5), Sub(Number(10), Number(3))) // 5 + (10 - 3) = 12
    println(eval(e)) // 12


/* ------------------------------------ Part 4 - Traits ------------------------------------ */

// 26. Create a Greeting trait with an abstract greet method and implement it in the Person class.

trait Greeting:
    def greet(): String  // Méthode abstraite

class Person2(val firstName: String, val lastName: String) extends Greeting:
    override def greet(): String = s"Hello, I'm $firstName $lastName"

// 27. Define a Comparable[T] trait with methods isGreaterThan, isLessThan, and implement it for the Point class (compare by distance from origin).

trait Comparable[T]:
    def isGreaterThan(other: T): Boolean
    def isLessThan(other: T): Boolean

class Point3(val x: Double, val y: Double) extends Comparable[Point3]:
    private def distanceFromOrigin: Double = math.sqrt(x * x + y * y)
    
    def isGreaterThan(other: Point3): Boolean =
        this.distanceFromOrigin > other.distanceFromOrigin
        
    def isLessThan(other: Point3): Boolean =
        this.distanceFromOrigin < other.distanceFromOrigin
        
    override def toString: String = s"($x,$y)"

// 28. Create a Logger trait with concrete log methods and mix it into the Person class.

trait Logger:
  def log(msg: String): Unit = println(s"LOG: $msg")
  def info(msg: String): Unit = log(s"INFO: $msg")
  def warn(msg: String): Unit = log(s"WARNING: $msg")
  def error(msg: String): Unit = log(s"ERROR: $msg")

class Person3(val firstName: String, val lastName: String) extends Logger:
    def fullName: String = s"$firstName $lastName"
  
    def introduce(): Unit =
        info(s"Introducing ${fullName}")
        log(s"Hello, my name is ${fullName}")

// 29. Design a Cloneable[T] trait with a clone method and implement it for the Rectangle class.

// 29. Design a trait for cloning and implement it for the Rectangle class
trait Copyable[T]:
  def deepCopy(): T  // Nom différent pour éviter le conflit avec Object.clone()

class Rectangle4(val topLeft: Point, val bottomRight: Point) extends Copyable[Rectangle4]:
  // Calcul de la largeur, hauteur et aire
  def width: Double = bottomRight.x - topLeft.x
  def height: Double = bottomRight.y - topLeft.y
  def area: Double = width * height
  
  // Implémentation sans utiliser "clone"
  def deepCopy(): Rectangle4 =
    new Rectangle4(
      new Point(topLeft.x, topLeft.y),
      new Point(bottomRight.x, bottomRight.y)
    )
  
  override def toString: String = s"Rectangle($topLeft, $bottomRight)"

// 30. Create a Worker trait with abstract doWork method and a LazyWorker trait that overrides doWork to print ”I’m lazy”. Mix them in a class.

trait Worker:
  def doWork(): String 

trait LazyWorker extends Worker:
    override def doWork(): String = "I'm lazy"

class Employee(val name: String) extends Worker with LazyWorker:
    def introduce(): String = s"Hi, I'm $name"

// 31. Implement a Ordered[Person] trait to make Person objects comparable by their full names.



class PersonOrdered(val firstName: String, val lastName: String) extends Ordered[PersonOrdered]:
    
    def fullName: String = s"$firstName $lastName"
    
    def compare(that: PersonOrdered): Int = 
        this.fullName.compare(that.fullName)
    
    override def toString: String = fullName


@main def runApp4(): Unit =
    import scala.math.Ordered

    val p1 = new Point3(3, 4)  // distance = 5
    val p2 = new Point3(1, 2)  // distance = 2.23...
    println(p1.isGreaterThan(p2))  // Output: true
    println(p2.isLessThan(p1))     // Output: true

    val person3 = new Person3("John", "Doe")
    person3.introduce()

    val rect = new Rectangle4(new Point(1, 1), new Point(5, 4))
    val copiedRect = rect.deepCopy()
    println(s"Original: $rect")
    println(s"Copy: $copiedRect")

    val lazyEmployee = new Employee("Bob")
    println(lazyEmployee.introduce())  // Output: Hi, I'm Bob
    println(lazyEmployee.doWork())     // Output: I'm lazy
    
    trait HardWorker extends Worker:
        override def doWork(): String = "I'm working very hard!"
    
    class Contractor(val name: String) extends Worker:
        def doWork(): String = s"$name is working at a normal pace"
    
    val hardWorker = new Contractor("Alice") with HardWorker
    val normalWorker = new Contractor("Charlie")
    
    println(hardWorker.doWork())   // Output: I'm working very hard!
    println(normalWorker.doWork()) 

    val people = List(
        new PersonOrdered("John", "Smith"),
        new PersonOrdered("Alice", "Johnson"),
        new PersonOrdered("Bob", "Anderson"),
        new PersonOrdered("Alice", "Brown")
    )
    
    val sortedPeople = people.sorted
    
    println("Personnes triées par nom complet:")
    sortedPeople.foreach(println)
    
    val p1_ = new PersonOrdered("John", "Smith")
    val p2_ = @@new PersonOrdered("Alice", "Johnson")
    
    println(s"${p1} est plus grand que ${p2}: ${p1 > p2}")
    println(s"${p1} est plus petit que ${p2}: ${p1 < p2}")
    println(s"${p1} est égal à ${p2}: ${p1 == p2}")
```


#### Short summary: 

empty definition using pc, found symbol in pc: 