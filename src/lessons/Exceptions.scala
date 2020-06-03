package lessons

object Exceptions extends App {
  val x : String = null
//  println(x.e)
  try {
    throw new NullPointerException
  } catch {
    case e:NullPointerException => println("hello null")
  }

  throw new MyExc
}

class MyExc extends Exception("this is fun")
