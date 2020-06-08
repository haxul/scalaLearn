package practice

import scala.annotation.tailrec

object TestSet extends App {
  val sf: (Int, Int) => Int = (x, y) => x + y

  def sm(x: Int, y: Int): Int = x + y

  def cm(x: Int)(y: Int): Int = x + y

  val add7: Int => Int = sf.curried(7)
  val add7M = cm(7) _
  val add7Sm = sm(7, _)

  def sayHello(greet: String, name: String, quastion: String) = s"${greet}, ${name}. ${quastion}"

  val sayByName = sayHello("Hello", _: String, "How ara you?")

  def byName(n: => Int) = n + 1

  lazy val y = throw new RuntimeException

  def fibonacci(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n - 1) + fibonacci(n - 2)
    }
  }
  val fibNumbers = LazyList from 0 map fibonacci take 20
  fibNumbers foreach println
}

class MySet[A](args: A*) {
  private val state: List[A] = args toList

  def apply(): MySet[A] = new MySet()

  def contains(el: A): Boolean = {
    @tailrec
    def isExist(xs: List[A]): Boolean = {
      xs match {
        case Nil => false
        case _ => if (xs.head == el) true else isExist(xs.tail)
      }
    }

    isExist(state)
  }

  def add(el: A) = new MySet[A](args :+ el: _*)

  override def toString: String = {
    @tailrec
    def show(ys: List[A], acc: String = ""): String = {
      ys match {
        case Nil => s"MySet( ${acc} )"
        case _ => show(ys.tail, s"${acc}, ${ys.head}")
      }
    }

    show(state) replaceFirst(",", "")
  }
}

