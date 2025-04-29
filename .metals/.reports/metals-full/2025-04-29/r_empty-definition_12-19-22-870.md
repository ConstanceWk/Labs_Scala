error id: 
file://<WORKSPACE>/Ex1.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 4788
uri: file://<WORKSPACE>/Ex1.scala
text:
```scala
// @ realised by Constance WALUSIAK - DAI 

// ----- HOMEWORK ----- //

// Write a course application that holds an in memory store students
// A student has a name, email and a note

// The application should be run in consol using command line

// The application should list students
// Search a given Student by Name
// Update a student in memory 
// Delete a student by it's name

import scala.io.StdIn.readLine

case class Student(name: String, email: String, note: Double)

object StudentApp:

  private var students: List[Student] = List()

  def main(args: Array[String]): Unit =
    println("\n=== Welcome to the Student Manager CLI ===")
    var running = true
    while running do
      printMenu()
      val input = readLine("Choose an option (1-6): ").trim
      input match
        case "1" => listStudents()
        case "2" => searchStudent()
        case "3" => addStudent()
        case "4" => updateStudent()
        case "5" => deleteStudent()
        case "6" =>
          println("Exiting... Goodbye!")
          running = false
        case _ => println("Invalid option. Please choose again.")

  def printMenu(): Unit =
    println("\nMenu:")
    println("1. List all students")
    println("2. Search student by name")
    println("3. Add new student")
    println("4. Update student")
    println("5. Delete student by name")
    println("6. Exit")

  def listStudents(): Unit =
    if students.isEmpty then println("No students available.")
    else
      println("\nList of Students:")
      students.zipWithIndex.foreach { case (s, i) =>
        println(s"${i + 1}. Name: ${s.name}, Email: ${s.email}, Note: ${s.note}")
      }

  def searchStudent(): Unit =
    val name = readLine("Enter name to search: ").trim
    val exactMatches = students.filter(_.name.equalsIgnoreCase(name))
    if exactMatches.nonEmpty then
      exactMatches.foreach(s => println(s"Found - Name: ${s.name}, Email: ${s.email}, Note: ${s.note}"))
    else
      val suggestions = students.filter(_.name.toLowerCase.contains(name.toLowerCase))
      if suggestions.nonEmpty then
        println(s"No exact match found for '$name'. Did you mean:")
        suggestions.zipWithIndex.foreach { case (s, idx) => println(s"${idx + 1}. ${s.name}") }
        val choice = readLine("Choose a number to view the student, or press ENTER to cancel: ").trim
        if choice.nonEmpty then
          choice.toIntOption match
            case Some(num) if num >= 1 && num <= suggestions.length =>
              val s = suggestions(num - 1)
              println(s"Selected - Name: ${s.name}, Email: ${s.email}, Note: ${s.note}")
            case _ => println("Invalid selection or cancelled.")
        else println("Returning to main menu.")
      else
        println(s"No student found with name containing '$name'.")

  def readNonEmptyLine(prompt: String): String =
    var line: String = ""
    do
      line = readLine(prompt).trim
      if line.isEmpty then println("Input cannot be empty.")
    while line.isEmpty
    line

  def readNote(): Double =
    var valid = false
    var note = -1.0
    while !valid do
      val input = readLine("Enter student's note (0-20): ").trim
      input.toDoubleOption match
        case Some(value) if value >= 0 && value <= 20 =>
          note = value
          valid = true
        case _ => println("Invalid note. Please enter a number between 0 and 20.")
    note

  def addStudent(): Unit =
    val name = readNonEmptyLine("Enter student's name: ")
    val email = readNonEmptyLine("Enter student's email: ")
    val note = readNote()
    students = students :+ Student(name, email, note)
    println("Student added successfully.")

  def updateStudent(): Unit =
    val name = readLine("Enter the name of the student to update: ").trim
    students.indexWhere(_.name.equalsIgnoreCase(name)) match
      case -1 => println(s"No student found with name '$name'.")
      case idx =>
        val current = students(idx)
        val newEmail = readLine(s"Enter new email [${current.email}]: ").trim
        val newNoteStr = readLine(s"Enter new note [${current.note}]: ").trim
        val newNote =
          if newNoteStr.isEmpty then current.note
          else
            newNoteStr.toDoubleOption match
              case Some(value) if value >= 0 && value <= 20 => value
              case _ =>
                println("Invalid note. Keeping the current value.")
                current.note
        val updated = current.copy(
          email = if newEmail.nonEmpty then newEmail else current.email,
          note = newNote
        )
        students = students.updated(idx, updated)
        println("Student updated successfully.")

  def deleteStudent(): Unit =
    val name = readLine("Enter the name of the student to delete: ").trim
    @@val (toDelete, rest) = students.partition(_.name.equalsIgnoreCase(name))
    if toDelete.isEmpty then println(s"No student found with name '$name'.")
    else
      students = rest
      println(s"Deleted ${toDelete.length} student(s) with name '$name'.")




// ajout de la fonctionnalité did you mean 
// securisation du type pour l entrée des valeurs
```


#### Short summary: 

empty definition using pc, found symbol in pc: 