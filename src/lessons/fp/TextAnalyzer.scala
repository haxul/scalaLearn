package lessons.fp

object TextAnalyzer extends App {

  def say(s:String)(w:String) :String = s + w
  val sayHello = say("Hello ") (_)
  println(sayHello(" My Friend"))
}
