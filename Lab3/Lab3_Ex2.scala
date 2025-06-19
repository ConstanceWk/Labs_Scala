object ScalaOOPWorkshop extends App {
  println("=== Exercice 1: Classes et Constructeurs ===")
  class Person(val name: String, var age: Int, private val id: Int) {
    // Constructeur auxiliaire
    def this(name: String) = this(name, 0, util.Random.nextInt(1000))
    
    def introduce(): String = s"Je m'appelle $name, j'ai $age ans."
  }
  
  val p1 = new Person("Alice", 30, 123)
  val p2 = new Person("Bob") // Utilise le constructeur auxiliaire
  
  println(p1.introduce())
  p2.age = 25 // Modification de l'attribut mutable
  println(p2.introduce())

  println("\n=== Exercice 2: Héritage de Classes ===")
  abstract class Shape(val color: String) {
    def area: Double // Méthode abstraite
    def perimeter: Double // Méthode abstraite
    def describe: String = s"$color shape with area ${area} and perimeter ${perimeter}"
  }
  
  class Circle(color: String, radius: Double) extends Shape(color) {
    def area: Double = math.Pi * radius * radius
    def perimeter: Double = 2 * math.Pi * radius
    override def describe: String = s"$color circle with radius $radius"
  }
  
  class Rectangle(color: String, val width: Double, val height: Double) extends Shape(color) {
    def area: Double = width * height
    def perimeter: Double = 2 * (width + height)
    override def describe: String = s"$color rectangle with width $width and height $height"
  }
  
  val circle = new Circle("Red", 5.0)
  val rectangle = new Rectangle("Blue", 4.0, 6.0)
  
  println(circle.describe)
  println(rectangle.describe)
  println(s"Circle area: ${circle.area}")
  println(s"Rectangle perimeter: ${rectangle.perimeter}")

  println("\n=== Exercice 3: Case Classes ===")
  case class Email(user: String, domain: String) {
    def asString: String = s"$user@$domain"
  }
  
  val email1 = Email("alice", "example.com")
  val email2 = Email("alice", "example.com")
  val email3 = Email("bob", "example.com")
  
  println(s"email1 == email2: ${email1 == email2}") // true - les case classes ont equals
  println(s"email1 == email3: ${email1 == email3}") // false
  
  val email4 = email1.copy(domain = "gmail.com") // Méthode copy pour non-destructive update
  println(s"email4: $email4")
  
  // Pattern matching avec case class
  def processEmail(email: Email): String = email match {
    case Email(user, "example.com") => s"Corporate email for $user"
    case Email("admin", _) => "Admin email"
    case Email(user, domain) => s"User email: $user@$domain"
  }
  
  println(processEmail(email1))
  println(processEmail(Email("admin", "gmail.com")))
  println(processEmail(email4))

  println("\n=== Exercice 4: Objects et Companion Objects ===")
  object MathUtils {
    val PI = 3.14159265359
    val E = 2.71828182846
    
    def square(x: Double): Double = x * x
    def cube(x: Double): Double = x * x * x
  }
  
  println(s"PI: ${MathUtils.PI}")
  println(s"Square of 5: ${MathUtils.square(5)}")
  println(s"Cube of 3: ${MathUtils.cube(3)}")
  
  class BankAccount private (val balance: Double) {
    def deposit(amount: Double): BankAccount = 
      new BankAccount(balance + amount)
    
    def withdraw(amount: Double): BankAccount = 
      if (amount <= balance) new BankAccount(balance - amount)
      else {
        println("Insufficient funds")
        this
      }
    
    override def toString: String = s"Account(balance=$balance)"
  }
  
  object BankAccount {
    // Factory method
    def apply(initialBalance: Double): BankAccount = 
      new BankAccount(initialBalance)
    
    // Alternative constructor
    def fromString(s: String): Option[BankAccount] = 
      s.toDoubleOption.map(new BankAccount(_))
  }
  
  val account1 = BankAccount(1000.0) // Using apply factory method
  val account2 = account1.deposit(500.0)
  val account3 = BankAccount.fromString("750.0")
  
  println(account1)
  println(account2)
  println(account3)

  println("\n=== Exercice 5: Traits de Base ===")
  trait Logger {
    def log(msg: String): Unit // Méthode abstraite
    
    // Méthodes concrètes basées sur la méthode abstraite
    def info(msg: String): Unit = log(s"INFO: $msg")
    def warn(msg: String): Unit = log(s"WARNING: $msg")
    def error(msg: String): Unit = log(s"ERROR: $msg")
  }
  
  class ConsoleLogger extends Logger {
    def log(msg: String): Unit = println(msg)
  }
  
  class FileLogger(val filename: String) extends Logger {
    def log(msg: String): Unit = {
      println(s"[Writing to $filename]: $msg")
      // Dans une implémentation réelle, écrirait dans un fichier
    }
  }
  
  val consoleLogger = new ConsoleLogger
  val fileLogger = new FileLogger("app.log")
  
  consoleLogger.info("Application started")
  consoleLogger.warn("Low memory")
  fileLogger.error("Connection failed")

  println("\n=== Exercice 6: Traits Paramétrés ===")
  trait Greeting(val prefix: String) {
    def greet(name: String): String = s"$prefix $name"
  }
  
  class FormalGreeter extends Greeting("Dear")
  class CasualGreeter extends Greeting("Hey")
  
  val formalGreeter = new FormalGreeter
  val casualGreeter = new CasualGreeter
  
  println(formalGreeter.greet("Alice")) // Dear Alice
  println(casualGreeter.greet("Bob"))   // Hey Bob

  println("\n=== Exercice 7: Traits Empilables ===")
  abstract class IntQueue {
    def get(): Int
    def put(x: Int): Unit
  }
  
  import scala.collection.mutable.ArrayBuffer
  
  class BasicQueue extends IntQueue {
    private val buffer = ArrayBuffer.empty[Int]
    
    def get(): Int = buffer.remove(0)
    def put(x: Int): Unit = buffer += x
    
    override def toString: String = s"Queue(${buffer.mkString(", ")})"
  }
  
  trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = super.put(2 * x)
  }
  
  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = super.put(x + 1)
  }
  
  val queue1 = new BasicQueue with Doubling
  val queue2 = new BasicQueue with Incrementing
  val queue3 = new BasicQueue with Doubling with Incrementing
  val queue4 = new BasicQueue with Incrementing with Doubling
  
  queue1.put(10)
  queue2.put(10)
  queue3.put(10)
  queue4.put(10)
  
  println(s"queue1: $queue1") // Contient 20 (10 * 2)
  println(s"queue2: $queue2") // Contient 11 (10 + 1)
  println(s"queue3: $queue3") // Contient 21 ((10 * 2) + 1)
  println(s"queue4: $queue4") // Contient 22 ((10 + 1) * 2)

  println("\n=== Exercice 8: Self Types ===")
  case class User(id: Int, name: String)
  
  trait UserRepository {
    def findUser(id: Int): Option[User]
    def allUsers: List[User]
  }
  
  trait UserService { self: UserRepository =>
    // Self-type: UserService requiert UserRepository
    def getUserName(id: Int): String = 
      findUser(id).map(_.name).getOrElse("Unknown")
    
    def countUsers(): Int = allUsers.size
  }
  
  class UserModule extends UserRepository with UserService {
    // Simuler une base de données en mémoire
    private val users = Map(
      1 -> User(1, "Alice"),
      2 -> User(2, "Bob"),
      3 -> User(3, "Charlie")
    )
    
    def findUser(id: Int): Option[User] = users.get(id)
    def allUsers: List[User] = users.values.toList
  }
  
  val userModule = new UserModule
  
  println(s"User 1: ${userModule.getUserName(1)}")
  println(s"User 4: ${userModule.getUserName(4)}")
  println(s"Total users: ${userModule.countUsers()}")

  println("\n=== Exercice 9: Extension Methods ===")
  trait StringExtensions {
    extension (s: String) {
      def toTitleCase: String = 
        s.split(" ").map(_.capitalize).mkString(" ")
      
      def encrypt(shift: Int): String = 
        s.map(c => (c + shift).toChar)
    }
  }
  
  object StringUtils extends StringExtensions
  
  import StringUtils._
  
  val str1 = "hello world"
  val str2 = "scala programming"
  
  println(s"Titlecase: ${str1.toTitleCase}")
  println(s"Encrypted: ${str2.encrypt(2)}")

  println("\n=== Exercice 10: Factory Pattern avec Companion ===")
  sealed abstract class DatabaseConfig {
    def connectionString: String
  }
  
  object DatabaseConfig {
    // Implémentations privées
    private case class PostgresConfig(host: String, port: Int, db: String) extends DatabaseConfig {
      def connectionString: String = s"postgres://$host:$port/$db"
    }
    
    private case class MongoConfig(uri: String) extends DatabaseConfig {
      def connectionString: String = s"mongodb://$uri"
    }
    
    // Méthodes Factory publiques
    def postgres(host: String, port: Int, db: String): DatabaseConfig = 
      PostgresConfig(host, port, db)
    
    def mongo(uri: String): DatabaseConfig = 
      MongoConfig(uri)
    
    // Utiliser pattern matching sur le type scellé
    def describe(config: DatabaseConfig): String = config match {
      case _: PostgresConfig => "PostgreSQL database"
      case _: MongoConfig => "MongoDB database"
    }
  }
  
  val postgresDB = DatabaseConfig.postgres("localhost", 5432, "myapp")
  val mongoDB = DatabaseConfig.mongo("localhost/mydb")
  
  println(s"Postgres connection: ${postgresDB.connectionString}")
  println(s"Mongo connection: ${mongoDB.connectionString}")
  println(s"Postgres type: ${DatabaseConfig.describe(postgresDB)}")
  println(s"Mongo type: ${DatabaseConfig.describe(mongoDB)}")
}