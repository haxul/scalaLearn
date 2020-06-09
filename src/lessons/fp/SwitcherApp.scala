package lessons.fp

object SwitcherApp extends App {

  trait Switcher[+A] {
    def flatMap[B](f: A => Switcher[B]): Switcher[B]
    def fold(f : Int => Int):Int
  }

  object Switcher {
    def apply(a:Int): Switcher[Int] = if (a > 100) High(a) else Low(a)
  }

  case class Low[A](a:Int) extends Switcher[Int] {
    override def flatMap[B](f: Int => Switcher[B]): Switcher[B] = f(a)
    def fold(f : Int => Int):Int = f(a)
  }

  case class High[A](a:Int) extends Switcher[Int] {
    override def flatMap[B](f: Int => Switcher[B]): Switcher[B] = f(a)
    def fold(f : Int => Int):Int = f(a)
  }

  val x = Switcher(10)
    .flatMap(x => Switcher(x - 100))
    .flatMap(x => Switcher(x * 10))
    .fold(x => x)

  println(x)
//  x match {
//    case Low(n) => println(n + " is low")
//    case High(n) => println(n + "is high")
//  }
}
