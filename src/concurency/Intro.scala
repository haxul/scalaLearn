package concurency

import java.util.concurrent.{Executors, TimeUnit}

object Intro extends App {

  val aThread = new Thread(() => {
    println("hello world")
    Thread.sleep(3000)
  })



  val account = new Account

  val pool = Executors.newFixedThreadPool(100)
  for (_ <- 1 to 10000) {
    pool.execute(()=> account.buy()
    )
  }
  pool.shutdown()
  pool.awaitTermination(1, TimeUnit.HOURS)

  println(account.sum)
  def reverseThread(i:Int): Unit = {
    if (i == 0) ()
    else {
      val thread = new Thread(() => println(i))
      thread.start()
      thread.join()
      reverseThread(i - 1)
    }
  }
}

class Account {
  var  sum = 0

  def buy() = {
      this.wait()
      sum += 1
      this.notify()
  }
}
