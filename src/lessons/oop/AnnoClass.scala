package lessons.oop
import scala.language.postfixOps

object AnnoClass extends App{

  case class Persons(name:String, age:Int)
  val jim = new Persons("jim", 44)
  val singelton = Persons
  val anotherPerson = singelton("some", 22)

  case object Simple {
    def say: String = "hello world"
  }
  println(Simple say)
}
