package reflaction
import scala.reflect.runtime.{universe => ru}

object Reflection extends App {

  case class Person(name: String) {
    def sayName(): Unit = println(name)
  }

  val m = ru.runtimeMirror(getClass.getClassLoader)
  val clazz = m.staticClass("reflaction.Reflection.Person")
  val cm = m.reflectClass(clazz)
  val constructor = clazz.primaryConstructor.asMethod
  val constructorMirror = cm.reflectConstructor(constructor)
  val instance = constructorMirror.apply("Hello")
  println(instance)

}

