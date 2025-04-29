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
    // val char: Char = 'a'
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
    println(s"2 + 2 = ${2 + 2}") // prints 2 + 2 = 4
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

// for yield 
    val doubles = for i <- ints yield i * 2

    val names = List("chris", "ed", "maurice")
    val capName = for name <- names yield name.capitalize

    val fruits = List("apple", "banana", "cherry")
    // match expression
    val i = 1
    i match
        case 1 => println("one")
        case 2 => println("two")
        case _ => println("other")

    val result = i match
        case 1 => "one"
        case 2 => "two"
        case _ => "other"
    
    // val person = Person("Fred")
    person match
        case Person(name, age) if name == "Fred" && age != 0 =>
            println(s"$name says, welcome to life")

        case Person(name, _) if name == "Bam Bam" =>
            println(s"$name says, Bam bam !")
        
        case _ => println("Watch the flintstones")


    trait Animal
    trait Dog extends Animal
    trait Cat extends Animal

    // Methods
    def add(x: Int, y: Int): Int = x + y

    def concat(x: String, y: String): String = x + y

    def sum(xs: List[Int]) = xs.sum

    // Singleton object
    object Value:
        def add(x: Int, y: Int): Int = x + y
        def concat(x: String, y: String): String = x + y
        
        val added = Value.add(1,2)
        val concatenated = Value.concat("Hello", "World")
    
    // Enums
    enum Color:
        case Red, Green, Blue

    enum Size:
        case Small, Medium, Large
    
    enum Color(val rgb: Int):
        case Red extends Color(0xFF0000)
        case Green extends Color(0x00FF00)
        case Blue extends Color(0x0000FF)
    
        

    // ------------------------------------- EXERCISE 1 ------------------------------------- //
    // Introduce a list of 5 Person
    // Print persons that have age > 40


    // Define a case class for Person
    val persons = List(
        Person("John", 25),
        Person("Jane", 35),
        Person("Bob", 45),
        Person("Alice", 55),
        Person("Charlie", 65)
    )
    val personsOver40 = for person <- persons if person.age > 40 yield person
    println("Persons over 40:")
    for person <- personsOver40 do
        println(person.name)
