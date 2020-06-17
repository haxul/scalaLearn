package tepeSystem

object Variance extends App {
  trait Animal
  class Dog extends Animal
  class Cat extends Animal
  class Crocodile extends Animal

  class CCage[+T]
  val ccage: CCage[Animal] = new CCage[Cat]

  class XCage[-T]
  val xcage:XCage[Cat] = new XCage[Animal]

  class MyList[+A] {
    def apply[B >: A](el: B):MyList[B] = new MyList[B]
  }
  val list = new MyList[Animal]
  list.apply(new Dog)
}
