package lessons.fp

object Monoids extends App {

  trait Attempt[+A] {
    def flapMap[B](f: A => Attempt[B]): Attempt[B]
  }

  object Attempt {
    def apply[A](a: => A): Attempt[A] = {
      try {
        Success(a)
      } catch {
        case e: Throwable => Failure(e)
      }
    }
  }

  case class Success[+A](value: A) extends Attempt[A] {
    override def flapMap[B](f: A => Attempt[B]): Attempt[B] = {
      try {
        f(value)
      } catch {
        case e: Throwable => Failure(e)
      }
    }
  }

  case class Failure(e: Throwable) extends Attempt[Nothing] {
    override def flapMap[B](f: Nothing => Attempt[B]): Attempt[B] = this
  }

  //  val xff = throw new Error
    println(Attempt(10).flapMap(x => Attempt(x + 10)))
  def squareFunction(x: Int): Option[Int] = Some(x * x)

  val x = 5
  val monad: Option[Int] = Some(x)
  val result = monad.flatMap(squareFunction) == squareFunction(x)

  val m = List(1, 2, 3)

  def unit(x: Int): List[Int] = List(x)

  def f(x: Int): List[Int] = List(x * x)

  def g(x: Int): List[Int] = List(x * x * x)

  val y = 1


  class Lazy[+T](value: T) {
    def flatMap[B](f: T => Lazy[B]): Lazy[B] = f(value)
  }

  object Lazy {
    def unit[T](v: => T): Lazy[T] = new Lazy(v)
  }
}
