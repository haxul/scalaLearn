package lessons

import scala.annotation.tailrec

object Strings extends App {
  println('g' +: "hello")
  def splitIf (el: String):List[Char] = {
    @tailrec
    def loop(i:Int = 0 : Int, acc:List[Char] = List()) : List[Char] = {
      if (i == el.length) acc
      else loop(i + 1 , acc :+ el(i) )
    }
    loop()
  }

  println(splitIf("hello"))
}
