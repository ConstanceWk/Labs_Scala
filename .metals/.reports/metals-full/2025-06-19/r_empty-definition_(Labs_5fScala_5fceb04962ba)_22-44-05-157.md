error id: file://<WORKSPACE>/Lab4/Lab4.scala:scala/Predef.Map.
file://<WORKSPACE>/Lab4/Lab4.scala
empty definition using pc, found symbol in pc: scala/Predef.Map.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Map.
	 -Map#
	 -Map().
	 -scala/Predef.Map.
	 -scala/Predef.Map#
	 -scala/Predef.Map().
offset: 3261
uri: file://<WORKSPACE>/Lab4/Lab4.scala
text:
```scala
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
val users = Map@@("1" -> User("john@example.com"))

def processUser(userId: String): Option[String] = {
  users.get(userId)
    .map(_.email)
    .filter(_.contains("@"))
    .map(email => s"Formatted: $email")
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
    }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Predef.Map.