package concurency

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Futures3 extends App {

  case class User(name: String)

  case class Transaction(sender: String, receiver: String, amount: Double, status: String)

  object BankingApp {
    def fetchUser(name:String) :Future[User] = Future {
      Thread.sleep(100)
        User(name)
    }

    def createTransaction(user:User, merchantName:String, amount:Double):Future[Transaction] = Future {
      Thread.sleep(1000)
      Transaction(user.name, merchantName, amount, "SUCCESS")
    }

    def purchase(username:String, item:String, merchantName:String, cost:Double) :String = {
      val transactionStatusFuture = for {
        user <- fetchUser(username)
        transaction <- createTransaction(user, merchantName, cost)
      } yield transaction.status

       Await.result(transactionStatusFuture, 2.seconds)
    }
  }
  println(BankingApp.purchase("Sergei", "iphone", "Apple", 12313))
}
