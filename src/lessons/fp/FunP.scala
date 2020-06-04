package lessons.fp

import scala.annotation.tailrec

object FunP extends App {

  val concat: (String, String) => String = (x: String, y: String) => x + y
  val func: (Int => Int, Int) => (Int) => Int = (f, x) => f
  val f = func((x) => x * 2, 10)
  val inc: Int => Int = _ + 1
  val sum: (Int, Int) => Int = _ + _

  val nTimes: ((Int) => Int, Int, Int) => Int = (f, x, n) => {
    if (n == 1) x
    else nTimes(f, f(x), n - 1)
  }

  def nTimesBetter(f: Int => Int, x: Int): Int => Int = nTimes.curried(f)(x)

  val sum10To10 = nTimesBetter(x => x + 10, 10)
  val summer = (x: Int) => (y: Int) => x + y
  val summer10 = summer(10)

  def foreach[A, B](f: (A) => B, xs: List[A]) = {
    @tailrec
    def rLoop(i: Int = 0): Unit = {
      if (i == xs.length) ()
      else {
        f(xs(i))
        rLoop(i + 1)
      }
    }

    rLoop()
  }

  def fold(xs: List[Int])(f: (Int, Int) => Int): Int = {
    @tailrec
    def forLoop(i: Int = 1, acc: Int = xs(0)): Int = {
      if (i == xs.length) acc
      else forLoop(i + 1, f(acc, xs(i)))
    }

    forLoop()
  }

  @tailrec
  def sumList(xs: List[Int], acc: Int = 0): Int = {
    if (xs.isEmpty) acc
    else sumList(xs.tail, xs.head + acc)
  }

  val result = List(1, 2, 3).flatMap((x: Int) => List(x, x + 10))
  println(result)
  val numbers = List(1, 2, 3)
  val chars = List("a", "b", "c")
  val words = List("hello", "world")

  val res = numbers.flatMap((x) => words.flatMap(w => chars.map(n => x + w + n)))
  println(res)
}

trait Function[A, B] {
  def apply(el: A): B
}
