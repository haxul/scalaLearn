package lessons

object Inheritance extends App {
  val x = MyType.empty[Int]
  println(x)
}


class MyType[A] ()

object MyType {
  def empty[A] :MyType[A] = _
}
