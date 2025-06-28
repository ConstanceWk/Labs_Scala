case class Person(name: String, age: Int, email: String) {
  def isAdult: Boolean = age >= 18
  def hasValidEmail: Boolean = {
    val emailRegex = """^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$""".r
    emailRegex.matches(email)
  }
}