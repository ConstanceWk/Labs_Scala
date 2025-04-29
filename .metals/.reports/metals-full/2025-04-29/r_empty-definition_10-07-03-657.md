error id: `<none>`.
file://<WORKSPACE>/Lab1.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1100
uri: file://<WORKSPACE>/Lab1.scala
text:
```scala
case class Person(name: String, age: Int=30)

@main def variables(): Unit = 
    // immutable
    val a = 0

    // mutable
    var b = 1

    //building types
    val byte: Byte = 1
    val short: Short = 2
    val int: Int = 3
    val long: Long = 4
    val float: Float = 5.0f
    val double: Double = 6.0
    val char: Char = 'a'
    val string: String = "Hello"
    val boolean: Boolean = true
    val person: Person = Person("John", 25)
    val person2: Person = Person("John")
    val person3: Person = Person("John", 25)
    val x = 2
    val index = 1000
    val j = 1.0

    val xx = 1_000_000L //val xx : Long = 1000000
    val yy = 2.2D //val yy : Double = 2.2


    // big values
    var bigInt: BigInt = BigInt(1_234_567_890_987L)
    var bigDecimal: BigDecimal = BigDecimal(123_456.789)


    // String vs Char
    val name = "Bill" // String
    val char = "c" // type inference to char

    // String templates or string interpolation
    val firstName = "Philipp"
    val cc = "C"
    val lastName = "Wadler"

    println(s"Hello, $firstName $cc $lastName")
    println(s"2 + 2 = ${@@2 + 2}") // prints 2 + 2 = 4
    val minus = -1
    println(s"x.abs = ${x.abs}") // prints x.abs = 1

    //multiline strings
    val quote = """The essence of Scala:
        Fusion of functional and object-oriented programming in a typed setting.
        """

    //control structures

    // Scala 2 version 
    if(x>0) {
        println("x is positive")
    } else if(x<0) {
        println("x is negative")
    } else {
        println("x is zero")
    }

    // Scala 3 version
    if x<0 then println("x is negative")
    else println("x is positive")

    // for loop 

    for i <- 1 to 10 do
        println(i)

    // print Hello multiple times 
    for _ <- 1 to 3 do
        println("Hello")
    
    val ints = List(1, 2, 3, 4, 5)

    for 
        i <- ints 
        if i > 2
    do
        println(i)


```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.