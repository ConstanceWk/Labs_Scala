// Exercice 1: Implementing map


def map[A, B](list: List[A], f: A => B): List[B] = list match
  case Nil => Nil
  case head :: tail => f(head) :: map(tail, f)

@main def testMap(): Unit =
  val numbers = List(1, 2, 3, 4, 5)
  val squared = map(numbers, (x: Int) => x * x)
  println (s"Original: $numbers")
  println(s"Squared: $squared") // should print: Squared: List(1, 4, 9, 16, 25)
  
  val doubled = map(numbers, x => x * 2)
    println(s"Doubled: $doubled") // should print: Doubled: List(2, 4, 6, 8, 10)


// Exercice 2: Implementing filter

// Implement filter using recursion
def filter[A](list: List[A], predicate: A => Boolean): List[A] = {
  // Your implementation here
  if (list.isEmpty) {
    List()
  } else {
    val head = list.head
    val tail = list.tail
    
    if (predicate(head)) {
      head :: filter(tail, predicate)
    } else {
      filter(tail, predicate)
    }
  }
}

// Test your implementation
@main def testFilter(): Unit = {
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  // Using explicit type
  val evens = filter(numbers, (x: Int) => x % 2 == 0)
  println(s"Even numbers: $evens") // Should print: Even numbers: List(2, 4, 6, 8, 10)
  
  // Using Scala 3's concise syntax
  val greaterThanFive = filter(numbers, _ > 5)
  println(s"Numbers > 5: $greaterThanFive") // Should print: Numbers > 5: List(6, 7, 8, 9, 10)
}


// Exercice 3: Implementing fold

// Implement fold using recursion
def fold[A, B](list: List[A], initial: B, combine: (B, A) => B): B = {
  if (list.isEmpty) {
    // Cas de base: si la liste est vide, retourner la valeur initiale
    initial
  } else {
    // Cas récursif: combiner l'accumulateur actuel avec la tête, puis traiter la queue
    val head = list.head
    val tail = list.tail
    
    // Nouvel accumulateur: combiner l'accumulateur initial avec la tête
    val newAccumulator = combine(initial, head)
    
    // Continuer la récursion avec la queue et le nouvel accumulateur
    fold(tail, newAccumulator, combine)
  }
}

// Test your implementation
@main def testFold(): Unit = {
  val numbers = List(1, 2, 3, 4, 5)
  
  // Sum of all numbers
  val sum = fold(numbers, 0, (acc, x) => acc + x)
  println(s"Sum: $sum") // Should print: Sum: 15
  
  // Product of all numbers
  val product = fold(numbers, 1, _ * _)
  println(s"Product: $product") // Should print: Product: 120
  
  // Building a string
  val joined = fold(numbers, "", (acc, x) => s"$acc$x")
  println(s"Joined: $joined") // Should print: Joined: 12345
}


// Exercice 4: Implementing compose

// Implement the compose function
def compose[A, B, C](f: B => C, g: A => B): A => C = {
  // Your implementation here
  (a: A) => f(g(a))
}

// Test your implementation
@main def testCompose(): Unit = {
  val addOne = (x: Int) => x + 1
  val double = (x: Int) => x * 2
  
  // Compose the functions
  val doubleThenAddOne = compose(addOne, double)
  val addOneThenDouble = compose(double, addOne)
  
  println(s"double(5) = ${double(5)}") // Should print: double(5) = 10
  println(s"addOne(5) = ${addOne(5)}") // Should print: addOne(5) = 6
  println(s"doubleThenAddOne(5) = ${doubleThenAddOne(5)}") // Should print: doubleThenAddOne(5) = 11
  println(s"addOneThenDouble(5) = ${addOneThenDouble(5)}") // Should print: addOneThenDouble(5) = 12
}


// Exercice 5: Currying and Partial Application


// Implement curry and uncurry
def curry[A, B, C](f: (A, B) => C): A => B => C = {
  // Your implementation here
  (a: A) => (b: B) => f(a, b)
}

def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
  // Your implementation here
  (a: A, b: B) => f(a)(b)
}

// Test your implementation
@main def testCurrying(): Unit = {
  // Original function
  val add = (a: Int, b: Int) => a + b
  
  // Curried version
  val curriedAdd = curry(add)
  
  // Using partial application
  val addFive = curriedAdd(5)
  
  println(s"add(3, 4) = ${add(3, 4)}") // Should print: add(3, 4) = 7
  println(s"curriedAdd(3)(4) = ${curriedAdd(3)(4)}") // Should print: curriedAdd(3)(4) = 7
  println(s"addFive(10) = ${addFive(10)}") // Should print: addFive(10) = 15
  
  // Uncurried version
  val uncurriedAdd = uncurry(curriedAdd)
  println(s"uncurriedAdd(3, 4) = ${uncurriedAdd(3, 4)}") // Should print: uncurriedAdd(3, 4) = 7
}

// Exercice 6: Function Composition with Scala 3 Extension Methods

// Implement function composition using Scala 3 extension methods
extension [A, B, C](f: B => C)
  def composeWith(g: A => B): A => C = {
    // Your implementation here
    (a: A) => f(g(a))
  }

// Test your implementation
@main def testExtensionComposition(): Unit = {
  val addOne = (x: Int) => x + 1
  val double = (x: Int) => x * 2
  
  // Using the extension method for composition
  val doubleThenAddOne = addOne.composeWith(double)
  
  println(s"doubleThenAddOne(5) = ${doubleThenAddOne(5)}") // Should print: doubleThenAddOne(5) = 11
  
  // Chaining multiple compositions
  val square = (x: Int) => x * x
  val pipeline = addOne.composeWith(double).composeWith(square)
  
  println(s"pipeline(3) = ${pipeline(3)}") // Should print: pipeline(3) = 19 (square(3) = 9, double(9) = 18, addOne(18) = 19)
  println(s"square(3) = ${square(3)}")
  println(s"double(9) = ${double(9)}")
  println(s"addOne(18) = ${addOne(18)}")
}

// Bonus Exercise: Implementing a Simple Collection Pipeline

def sumOfSquaresOfEven(numbers: List[Int]): Int = {
  // Your implementation here using filter, map, and fold
  // 1. Filtrer les nombres pairs
  // 2. Élever chaque nombre au carré
  // 3. Calculer la somme des carrés
  
  val evenNumbers = filter(numbers, (x: Int) => x % 2 == 0)
  val squares = map(evenNumbers, (x: Int) => x * x)
  val sum = fold(squares, 0, (acc: Int, x: Int) => acc + x)
  
  sum
}

// Test your implementation
@main def testPipeline(): Unit = {
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val result = sumOfSquaresOfEven(numbers)
  println(s"Sum of squares of even numbers: $result") // Should print: Sum of squares of even numbers: 220
} 