package lessons

import scala.annotation.tailrec

object Recursion extends App {

  @tailrec
  def helper(x : BigInt, acc:BigInt) :BigInt = {
    if (x <= 1) acc
    else helper(x - 1, x * acc)
  }

  @tailrec
  def concat(s: String, n: Int, acc : String = "") : String = {
    if (n == 0) acc
    else concat(s, n - 1, s  + " " + acc)
  }

  def fibonacciFunc(n : Int) : Int = {
    @tailrec
    def fibonacciTail (i : Int = 2, last : Int = 1, preLast : Int = 0 ) : Int  = {
      if (i >= n) last + preLast
      else fibonacciTail(i + 1, preLast + last, last)
    }
    fibonacciTail()
  }

}
