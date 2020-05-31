package lessons

import scala.annotation.tailrec

object Recursion extends App {
  @tailrec
  def helper(x : BigInt, acc:BigInt) :BigInt = {
    if (x <= 1) acc
    else helper(x - 1, x * acc)
  }
}
