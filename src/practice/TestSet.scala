package practice

import scala.annotation.tailrec

object TestSet extends App {
  val set:MySet[Int] = new MySet(1,2,3,4)
  val set2 = set add 5
}

class MySet[A](args: A*) {
  private val state : List[A] = args toList

  def apply(): MySet[A] = new MySet()

  def contains(el:A):Boolean = {
    @tailrec
    def isExist(xs:List[A]) : Boolean = {
      xs match {
        case Nil => false
        case _ => if (xs.head == el ) true else isExist(xs.tail)
      }
    }
    isExist(state)
  }

  def add(el:A) = new MySet[A](args :+ el:_*)

  override def toString: String = {
    @tailrec
    def show(ys: List[A], acc:String = ""): String = {
      ys match {
        case Nil => s"MySet( ${acc} )"
        case _ => show(ys.tail, s"${acc}, ${ys.head}")
      }
    }
    show(state) replaceFirst(",", "")
  }
}

