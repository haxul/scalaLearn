package concurency

object Communication extends App {
  val lock = new Object
  class Container {
    var value = 0
  }
  val container = new Container

  def producer() = {
    lock.synchronized {
      println("Producer is starting to compute")
      container.value = 10
      Thread.sleep(3000)
      println("Producer finished")
      lock.notify()
    }
  }
  def consumer() = {
    lock.synchronized {
      println("Consumer is waiting...")
      lock.wait()
      println(" I get value " + container.value)
      container.value = 0
    }
  }

  new Thread(() => consumer()).start()
  new Thread(() => producer()).start()
}
