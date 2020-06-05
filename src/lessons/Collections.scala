package lessons

object Collections extends App {
  val seq = Seq(1,2,3)
//  (1 until  10) foreach print
  val aList = List(1,2,3,4)
  println(20 +: aList :+ 10)
  val times = for {
    i <- 1 to 10
  } yield {
    i + 10
  }
  println(times)
}
