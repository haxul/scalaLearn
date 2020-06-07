package practice

object FunctianlProg extends App {

  val f: (Int => Int, Int) => Int = (f, x) => f(x)

  val list: List[Int] = List(1, 2, 3, 4).map {
    case 1 => 10
    case a => Math.pow(a, 2) toInt
  }
  val func: PartialFunction[Int, Int] = {
    case a => 1
  }

  //  println(set.array)
  //  scala.io.Source.stdin.getLines().foreach {
  //    case "hello" => println("hello I am chatbot")
  //    case "where money?" => println()
  //    case string => println("I do not understand you")
  //  }
}
