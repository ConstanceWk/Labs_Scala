error id: scala/collection/IterableOps#head().
file://<WORKSPACE>/Lab2/Lab2.scala
empty definition using pc, found symbol in pc: scala/collection/IterableOps#head().
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -list/head.
	 -list/head#
	 -list/head().
	 -scala/Predef.list.head.
	 -scala/Predef.list.head#
	 -scala/Predef.list.head().
offset: 1756
uri: file://<WORKSPACE>/Lab2/Lab2.scala
text:
```scala
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
// Implement fold using recursion
def fold[A, B](list: List[A], initial: B, combine: (B, A) => B): B = {
  if (list.isEmpty) {
    // Cas de base: si la liste est vide, retourner la valeur initiale
    initial
  } else {
    // Cas récursif: d'abord traiter la queue, puis combiner avec la tête
    val head = list.he@@ad
    val tail = list.tail
    
    // Combiner le résultat de la récursion sur la queue avec la tête
    val newAccumulator = fold(tail, initial, combine)
    combine(newAccumulator, head)
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/collection/IterableOps#head().