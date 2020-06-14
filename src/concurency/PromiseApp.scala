package concurency

import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object PromiseApp extends App {
  val promise = Promise[Int]()
  val future = promise.future
  val anotherPromise = Promise[Int]()

  anotherPromise.future.onComplete {
    case Success(n) => println("is " + n)
  }
  future.onComplete {
    case Success(value) => anotherPromise.success(value)
  }

  new Thread(() => {
    Thread.sleep(2000)
    promise.success(100)
  }).start()

  println("end")
  Thread.sleep(3000)
}
