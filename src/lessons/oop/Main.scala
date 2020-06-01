package lessons.oop

object Main extends App {
  val person = new Person("John")

  print(person.x)
}

class Person(val name:String) {
  val x = 100
}
