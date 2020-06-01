package lessons
import scala.language.postfixOps

object Notation extends App {

  def sum10(x : Int): Int = x + 10
  val mary = new Person(33)
  println(mary isMature 100 )
  println(~mary)
  println(mary sayHello)
  println(mary())
}


class Person(val age:Int) {
  def isMature(time:Int): Boolean = this.age > time
  def unary_~ : Int = age + 100
  def sayHello: String = "hello"
  def apply(): String = s"I am $age year old"
}
