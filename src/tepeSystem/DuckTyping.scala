package tepeSystem

object DuckTyping extends App {

  type JavaCloseable = java.io.Closeable

  class HipsterCloseable {
    def close(): Unit = println("close")
  }

  type UniClose = {
    def close(): Unit
  }

  def method(uniClose: UniClose): Unit = uniClose.close()

  method(new JavaCloseable {
    override def close(): Unit = println("ha")
  })

  //  method(new HipsterCloseable)
  type SoundMaker = {
    def makeSound(): Unit
  }

  class Dog {
    def makeSound(): Unit = println("raff")
  }

  class Car {
    def makeSound(): Unit = println("vroom")
  }

  val dog:SoundMaker = new Dog
  dog.makeSound()
}
