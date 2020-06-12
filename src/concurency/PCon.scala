package concurency

import java.util.concurrent.Executors

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object PCon extends App {

  var buffer = new mutable.Queue[Int](10)
  def consumer():Unit = {
    synchronized {
      println(buffer)
      if (buffer.length <= 1) wait()
      val value = buffer.dequeue()
      println(s"consumer gets number ${value} from buffer")
      notify()
    }
  }

  def producer(): Unit = {
    synchronized {
      if (buffer.length >= 5) wait()
      Thread.sleep(1000)
      val random = Random.between(0,10)
      buffer addOne random
      println(s"producer pushed into buffer -> ${random}")
      notify()
    }
  }
  while (true) {
    new Thread(()=> consumer()).start()
    new Thread(()=> producer()).start()
    Thread.sleep(1000)
  }
}
