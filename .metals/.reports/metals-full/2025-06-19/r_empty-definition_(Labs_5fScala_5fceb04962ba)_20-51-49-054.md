error id: file://<WORKSPACE>/Lab4/Lab4.scala:`<none>`.
file://<WORKSPACE>/Lab4/Lab4.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 735
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
    d@@ef readFileWithCleanup(filename: String): String = {
        try {
            if (filename == "valid.txt") "File content"
            else throw new Exception("File not found")
        } catch {
            case _: Exception => "Error reading file"
        } finally {
            println("Cleanup completed")
        }
    }
    def main(args: Array[String]): Unit = {
       
        println("=== Exercise 1: Basic Try-Catch ===")

        println(safeDivide(10, 2))
        println(safeDivide(10, 0))

        println("\n=== Exercise 2: Multiple Exception Types ===")

        println(parseAndDivide("10", "2"))
        println(parseAndDivide("abc", "2"))
        println(parseAndDivide("10", "0"))

        prin
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.