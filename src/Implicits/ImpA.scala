package Implicits

object ImpA extends App {

//  case class Person(name:String) {
//    def greet:String = s"my name is $name"
//  }
//
//  implicit def fromStringToPerson(str:String): Person = Person(str)
//  def increment(x:Int)(implicit amount:Int):Int = x + amount
//  implicit val defaultAmount: Int = 1

  case class Person(name:String, age:Int)
  val persons:List[Person] = List(
    Person("jon",23),
    Person("amy",21),
    Person("word",27),
    Person("scala",12),
  )
  implicit def ordering:Ordering[Person] = Ordering.fromLessThan((x, y) => x.name < y.name)
  println(persons.sorted)
}
