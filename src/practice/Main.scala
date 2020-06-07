package practice

object Main extends App{

  val list = List(1,2,3).map {
    x => x * 2
  }
  def say (word:String ) = s"I said ${word}"
  val result = say {
    "word"
  }

  val numbers = List(1)
//  val description: Unit = numbers match {
//    case head::Nil => println(s"${head} is on head")
//    case _ => println("nothing")
//  }
  object even {
    def unapply(arg: Int): Option[Boolean] = if (arg > 10 ) Some(true) else None
  }
  val n : Int = 1
  val ans:String = n match {
    case even(_) => "it is even"
    case _ => "is odd"
  }
}
