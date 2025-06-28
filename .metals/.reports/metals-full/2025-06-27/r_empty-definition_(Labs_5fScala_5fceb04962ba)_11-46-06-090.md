error id: file://<WORKSPACE>/lab6_unit/src/main/scala/11_UserService.scala:scala/Option#
file://<WORKSPACE>/lab6_unit/src/main/scala/11_UserService.scala
empty definition using pc, found symbol in pc: scala/Option#
semanticdb not found
empty definition using fallback
non-local guesses:
	 -Option#
	 -scala/Predef.Option#
offset: 288
uri: file://<WORKSPACE>/lab6_unit/src/main/scala/11_UserService.scala
text:
```scala
package main

case class User(id: Long, name: String)

trait UserRepository {
  def delete(id: Long): Unit
  def findById(id: Long): Option[User]
}

class UserService(userRepository: UserRepository) {
  def deleteUser(id: Long): Unit = userRepository.delete(id)
  def getUser(id: Long): O@@ption[User] = userRepository.findById(id)
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Option#