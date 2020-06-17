package tepeSystem

object TypeSystem extends App {

  trait Writer[T] {
    def write(value: T): Unit
  }

  trait Closeable {
    def close(status: Int): Int
  }

  trait GenericStream[T] {
    def foreach(f: T => Unit): Unit
  }

  class StreamClass[T] extends Writer[T] with Closeable with GenericStream[T] {
    override def write(value: T): Unit = println(value)

    override def close(status: Int): Int = status

    override def foreach(f: T => Unit): Unit = println("hello world")
  }
  val stream = new StreamClass[Int]
  def process[T](stream: Writer[T] with GenericStream[T] with Closeable): Unit = {
    stream.foreach(println)
//    stream.write()
  }
}
