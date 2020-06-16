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
//  println(persons.sorted)

  implicit class RichInt(value:Int) {
    def isEven():Boolean = value % 2 == 0
    def sqrt() :Double = Math.sqrt(value)
  }

  implicit class RichString(str:String) {
    def asInt() : Int = str.toCharArray.sum
  }

  implicit def stringToInt(str:String):Int = Integer.valueOf(str)


  val result = "Hello world".asInt()
  println("12" / 6)

}
