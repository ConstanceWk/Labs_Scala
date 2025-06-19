// BASIC EXCEPTION HANDLING (Exercises 1-8) //



object Lab4 {

// Exercise 1: Basic Try-Catch
    def safeDivide(a: Int, b: Int): String = {
        try {
            (a / b).toString
        } catch {
            case _: ArithmeticException => "Error: Division by zero"
        }
   }

// Exercise 2: Multiple Exception Types
    def parseAndDivide(numStr: String, denomStr: String): String = {
        try {
            val num = numStr.toInt
            val denom = denomStr.toInt
            (num / denom).toString
        } catch {
            case _: NumberFormatException => "Error: Invalid number format"
            case _: ArithmeticException => "Error: Division by zero"
        }
    }

// Exercise 3: Finally Block
    def readFileWithCleanup(filename: String): String = {
        try {
            if (filename == "valid.txt") "File content"
            else throw new Exception("File not found")
        } catch {
            case _: Exception => "Error reading file"
        } finally {
            println("Cleanup completed")
        }
    }

// Exercise 4: Custom Exception
    class NegativeNumberException(msg: String) extends Exception(msg)
    def calculateSquareRoot(n: Double): String = {
    try {
        if (n < 0) throw new NegativeNumberException("Cannot calculate square root of negative number")
        math.sqrt(n).toString
    } catch {
        case e: NegativeNumberException => s"Error: ${e.getMessage}"
    }
}

// Exercise 5: Exception Propagation
    def functionC(): Unit = throw new RuntimeException("Error in functionC")
    def functionB(): Unit = functionC()
    def functionA(): String = {
    try {
        functionB()
        "Success"
    } catch {
        case e: RuntimeException => s"Caught: ${e.getMessage}"
    }
    }

// Exercise 6: Exception with Context
    
    def validateAge(age: Int): String = {
    try {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative")
        if (age == 0) throw new IllegalArgumentException("Age cannot be zero")
        if (age >= 100) throw new IllegalArgumentException("Age seems unrealistic")
        "Age is valid"
    } catch {
        case e: IllegalArgumentException => s"Error: ${e.getMessage}"
    }
    }

// Exercise 7: Catching Specific vs General Exceptions
    def demonstrateExceptionHierarchy(): String = {
        try {
            throw new IllegalArgumentException("Specific error")
        } catch {
            case e: IllegalArgumentException => s"Caught specific: ${e.getMessage}"
            case e: Exception => s"Caught general: ${e.getMessage}"
        }
    }

// Exercise 8: Resource Management

    def databaseOperation(): String = {
    var connection: String = null
    try {
        connection = "DB Connection opened"
        println(connection)
        "Operation successful"
    } catch {
        case e: Exception => s"Operation failed: ${e.getMessage}"
    } finally {
        if (connection != null) {
        println("Connection closed")
        }
    }
    }

// Exercise 9: Basic Option Usage
    def findElement(list: List[Int], target: Int): Option[Int] = {
    list.zipWithIndex.find(_._1 == target).map(_._2)
    }

// Exercise 10: Option Chaining
    case class User(email: String)
    val users = Map("1" -> User("john@example.com"))

    def processUser(userId: String): Option[String] = {
    users.get(userId)
        .map(_.email)
        .filter(_.contains("@"))
        .map(email => s"Formatted: $email")
    }

// Exercise 11: Option with Default Values
    val config = Map("timeout" -> "30")

    def getConfigValue(key: String): String = {
    config.get(key).getOrElse("default")
    }

// Exercise 12: Combining Multiple Options
    def calculateTotal(price: Option[Double], tax: Option[Double], discount: Option[Double]): Option[Double] = {
    for {
        p <- price
        t <- tax
        d <- discount
    } yield p + t - d
    }

// Exercise 13: Option to Either Conversion
    def optionToEither[A](opt: Option[A], errorMsg: String): Either[String, A] = {
    opt.toRight(errorMsg)
    }

// Exercise 14: Filtering Options
    def validatePositive(numbers: List[Option[Int]]): List[Int] = {
    numbers.flatten.filter(_ > 0)
    }

// Exercise 15: Basic Either Usage
    def safeParseInt(str: String): Either[String, Int] = {
    try {
        Right(str.toInt)
    } catch {
        case _: NumberFormatException => Left("Invalid number format")
    }
    }

// Exercise 16: Either Chaining
    def validateAndProcess(input: String): Either[String, String] = {
    if (input.length < 3) Left("Input too short")
    else Right(input.toUpperCase).map("PREFIX_" + _)
    }

// Exercise 17: Accumulating Errors
    case class User17(name: String, email: String, age: Int)

    def validateForm(name: String, email: String, age: String): Either[List[String], User17] = {
    val errors = List(
        if (name.isEmpty) Some("Name is empty") else None,
        if (!email.contains("@")) Some("Invalid email") else None,
        if (age.toIntOption.forall(_ < 0)) Some("Invalid age") else None
    ).flatten
    
    if (errors.nonEmpty) Left(errors)
    else Right(User17(name, email, age.toInt))
    }

// Exercise 18: Either Bimap
    def processResult(result: Either[Exception, Int]): Either[String, String] = {
    result.left.map(_.getMessage).map(_.toString)
    }

// Exercise 19: Either Recovery
    def withFallback(primary: Either[String, Int], fallback: Either[String, Int]): Either[String, Int] = {
    primary.orElse(fallback)
    }

// Exercise 20: Either Partitioning
    def partitionResults(results: List[Either[String, Int]]): (List[String], List[Int]) = {
    val (lefts, rights) = results.partitionMap(identity)
    (lefts, rights)
    }

    import scala.util.{Try, Success, Failure}

// Exercise 21: Basic Try Usage
    def safeDivisionTry(a: Int, b: Int): Try[Int] = {
    Try(a / b)
    }

// Exercise 22: Try Chaining
    def parseAndSquare(str: String): Try[Int] = {
    Try(str.toInt).map(x => x * x)
    }

// Exercise 23: Try Recovery
    def readFileWithDefault(filename: String): Try[String] = {
    Try {
        if (filename == "existing.txt") "File content"
        else throw new Exception("File not found")
    }.recover {
        case _: Exception => "Default content"
    }
    }

// Exercise 24: Try to Either Conversion
    def tryToEither[T](t: Try[T]): Either[String, T] = {
    t.toEither.left.map(_.getMessage)
    }

    def main(args: Array[String]): Unit = {
       
        println("=== Exercise 1: Basic Try-Catch ===")

        println(safeDivide(10, 2))
        println(safeDivide(10, 0))

        println("\n=== Exercise 2: Multiple Exception Types ===")

        println(parseAndDivide("10", "2"))
        println(parseAndDivide("abc", "2"))
        println(parseAndDivide("10", "0"))

        println("\n=== Exercise 3: Finally Block ===\n")

        println(readFileWithCleanup("valid.txt"))
        println(readFileWithCleanup("autre.txt"))

        println("\n=== Exercise 4: Custom Exception ===")

        println(calculateSquareRoot(16.0))
        println(calculateSquareRoot(-4.0))

        println("\n=== Exercise 5: Exception Propagation ===")

        println(functionA())

        println("\n=== Exercise 6: Exception with Context ===")

        println(validateAge(25))
        println(validateAge(-5))
        println(validateAge(0))
        println(validateAge(150))

        println("\n=== Exercise 7: Catching Specific vs General Exceptions ===")

        println(demonstrateExceptionHierarchy())

        println("\n=== Exercise 8: Resource Management ===")

        println(databaseOperation())

        println("\n=== Exercise 9: Basic Option Usage ===")

        println(findElement(List(1, 2, 3), 2))
        println(findElement(List(1, 2, 3), 5))

        println("\n=== Exercise 10: Option Chaining ===")

        println(processUser("1"))
        println(processUser("999"))

        println("\n=== Exercise 11: Option with Default Values ===")
        println(getConfigValue("timeout"))
        println(getConfigValue("nonexistent"))

        println("\n=== Exercise 12: Combining Multiple Options ===")
        println(calculateTotal(Some(100.0), Some(20.0), Some(10.0))) 
        println(calculateTotal(Some(100.0), None, Some(10.0)))

        println("\n=== Exercise 13: Option to Either Conversion ===")
        println(optionToEither(Some("Success"), "Failed"))
        println(optionToEither(None, "Failed"))

        println("\n=== Exercise 14: Filtering Options ===")
        println(validatePositive(List(Some(1), Some(-2), None, Some(3)))) 
        println(validatePositive(List(None, Some(-1), Some(0))))

        println("\n=== Exercise 15: Basic Either Usage ===")
        println(safeParseInt("123"))
        println(safeParseInt("abc"))

        println("\n=== Exercise 16: Either Chaining ===")
        println(validateAndProcess("Hello"))
        println(validateAndProcess("Hi"))
        println(validateAndProcess("A"))

        println("\n=== Exercise 17: Accumulating Errors ===")
        println(validateForm("Alice", "sdergt", "12"))
        println(validateForm("Alice", "alice@gmail.com", "12"))

        println("\n=== Exercise 18: Either Bimap ===")
        val result1: Either[Exception, Int] = Right(42)
        val result2: Either[Exception, Int] = Left(new Exception("An error occurred " +
          "while processing"))  
        println(processResult(result1)) 
        println(processResult(result2)) 

        println("\n=== Exercise 19: Either Recovery ===")
        val primary: Either[String, Int] = Left("Primary failed")
        val fallback: Either[String, Int] = Right(100)
        println(withFallback(primary, fallback))
        println(withFallback(Right(50), fallback))

        println("\n=== Exercise 20: Either Partitioning ===")
        val results = List(Right(1), Left("Error 1"), Right(2), Left("Error 2"))
        val (errors, successes) = partitionResults(results) 
        println(s"Errors: $errors")
        println(s"Successes: $successes")

        println("\n=== Exercise 21: Basic Try Usage ===")
        println(safeDivisionTry(10, 2))
        println(safeDivisionTry(10, 0))

        println("\n=== Exercise 22: Try Chaining ===")
        println(parseAndSquare("4"))
        println(parseAndSquare("abc"))
        println(parseAndSquare("5"))

        println("\n=== Exercise 23: Try Recovery ===")
        println(readFileWithDefault("existing.txt"))
        println(readFileWithDefault("nonexistent.txt"))

        println("\n=== Exercise 24: Try to Either Conversion ===")
        val trySuccess: Try[Int] = Success(42)
        val tryFailure: Try[Int] = Failure(new Exception("An error occurred"))
        println(tryToEither(trySuccess))
        println(tryToEither(tryFailure)) 

    }

}