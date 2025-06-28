case class Userr(id: Long, name: String, age: Int)

class UserBuilder {
  private var id: Long = 1L
  private var name: String = "DefaultName"
  private var age: Int = 0

  def withId(newId: Long): UserBuilder = {
    id = newId
    this
  }

  def withName(newName: String): UserBuilder = {
    name = newName
    this
  }

  def withAge(newAge: Int): UserBuilder = {
    age = newAge
    this
  }

  def build(): Userr = Userr(id, name, age)
}
