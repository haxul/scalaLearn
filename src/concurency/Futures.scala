package concurency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Futures extends App {

  def returnSome():List[Int] = {
    Thread.sleep(2000)
    List(1, 2, 3, 5, 6)
  }

  val aFuture = Future {
    returnSome()
  }

  def test(s:String): Future[String] = Future {
    Thread.sleep(1000)
    val map = Map (
        "hello" -> "world",
        "ttt" -> "aaa"
      )
    map(s)
  }
//  val result = aFuture.flatMap(list => Future(list.map(y => y * 10)))
  val result = aFuture.map(list => list.map(y => y * 10))
//  val anotherResult = result.map(list => list.map(e => e + 1))
//  val name = test().filter(map => map("hello").equals("world"))

  val data = test("hello1").map(e => e.toUpperCase).fallbackTo {
    test("ttt")
  }
  println("here")
  for {
    y <- data
  } println(y)
  for {
    list <- result
  } println(list)
  //  aFuture.onComplete {
  //    case Success(value) => println(s"Succes $value")
  //    case Failure(exception) => println(s"$exception")
  //  }

  println("then")
  Thread.sleep(3000)

}
