// @ realised by Constance WALUSIAK - DAI 

// ----- HOMEWORK ----- //

// Write a course application that holds an in memory store students
// A student has a name, email and a note

// The application should be run in consol using command line

// The application should list students
// Search a given Student by Name
// Update a student in memory 
// Delete a student by it's name


// ----- OTHER FUNCTIONALITIES ----- //
// added "did you mean ... ?" feature if you misclick the name for the search name
// added validation to ensure the grade is valid

import scala.io.StdIn.readLine

case class Student(name: String, email: String, note: Double)

object StudentApp:
  private var students: List[Student] = List()

  def main(args: Array[String]): Unit =
    println("\n=== Hello you :) ! This is the Student Manager CLI ===")
    var running = true
    while running do
      printMenu()
      val input = readLine("Choose an option (1-6): ")
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
    if students.isEmpty then 
      println("No students available.")
    else
      println("\nList of Students:")
      for (i <- 0 until students.length)
        val s = students(i)
        println(s"${i + 1}. Name: ${s.name}, Email: ${s.email}, Note: ${s.note}")

  def searchStudent(): Unit =
    val name = readLine("Enter name to search: ")
    var found = false
    
    // First check for exact matches
    for (s <- students)
      if s.name.toLowerCase == name.toLowerCase then
        println(s"Found - Name: ${s.name}, Email: ${s.email}, Note: ${s.note}")
        found = true
    
    // If no exact match -> suggest similar names
    if !found then
      println(s"No exact match found for '$name'. Did you mean:")
      var hasSuggestions = false
      
      for (s <- students)
        if s.name.toLowerCase.contains(name.toLowerCase) then
          println(s" - ${s.name}")
          hasSuggestions = true
      
      if !hasSuggestions then
        println(s"No student found with name containing '$name'.")

  def addStudent(): Unit =
    val name = readLine("Enter student's name: ")
    val email = readLine("Enter student's email: ")
    val noteInput = readLine("Enter student's note (0-20): ")
    
    try
      val note = noteInput.toDouble
      if note < 0 || note > 20 then
        println("Invalid note. Please enter a number between 0 and 20.")
      else
        val newStudent = Student(name, email, note)
        students = students :+ newStudent
        println("Student added successfully.")
    catch
      case _: NumberFormatException => 
        println("Please enter a valid number for the note.")

  def updateStudent(): Unit =
    val name = readLine("Enter the name of the student to update: ")
    var found = false
    var index = 0
    
    // Find the student by name
    for (i <- 0 until students.length)
      if students(i).name.toLowerCase == name.toLowerCase then
        found = true
        index = i
    
    if found then
      val current = students(index)
      val newEmail = readLine(s"Enter new email [${current.email}]: ")
      val newNoteStr = readLine(s"Enter new note [${current.note}]: ")
      
      // Keep current email if no new one provided
      val finalEmail = if newEmail.isEmpty then current.email else newEmail
      
      // Handle note update
      var finalNote = current.note
      if !newNoteStr.isEmpty then
        try
          val newNote = newNoteStr.toDouble
          if newNote >= 0 && newNote <= 20 then
            finalNote = newNote
          else
            println("Invalid note. Keeping the current value.")
        catch
          case _: NumberFormatException => 
            println("Invalid note format. Keeping the current value.")
      
      // Create updated student and replace in list
      val updated = Student(current.name, finalEmail, finalNote)
      var newList: List[Student] = List()
      for (i <- 0 until students.length)
        if i == index then
          newList = newList :+ updated
        else
          newList = newList :+ students(i)
      
      students = newList
      println("Student updated successfully.")
    else
      println(s"No student found with name '$name'.")

  def deleteStudent(): Unit =
    val name = readLine("Enter the name of the student to delete: ")
    var newList: List[Student] = List()
    var deleted = 0
    
    for (s <- students)
      if s.name.toLowerCase == name.toLowerCase then
        deleted = deleted + 1
      else
        newList = newList :+ s
    
    if deleted > 0 then
      students = newList
      println(s"Deleted $deleted student(s) with name '$name'.")
    else
      println(s"No student found with name '$name'.")

