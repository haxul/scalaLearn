package tepeSystem

object TypeMembers extends App {

  trait Animal
  class Dog extends Animal
  class Cat extends Animal
  class Crocodile extends Animal

  class Outer {
    class Inner {
      val f = "string"
    }

  }
  def say(el : Outer#Inner) = println(el)
  val o = new Outer
  val inner = new o.Inner
  say(inner)
}
