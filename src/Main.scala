object Main extends App {

  def f(x:String)(y:Int):String = s"${x} ${y}"

  val fhello = f("hello")(_)
  print(fhello(123123))
}
