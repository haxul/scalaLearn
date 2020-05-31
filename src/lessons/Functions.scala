package lessons

object Functions extends App {

  def rStr(s:String, i:Int) : String = if (i == 1) s else s + " " + rStr(s, i - 1)
  def say(s:String) : String = s"hello ${s}"
  def factorial(a:Int) : Int = if (a == 1) 1 else a + factorial(a - 1)
  def fibonacci(a: Int) : Int = if (a == 1) 1 else if (a == 0) 0 else fibonacci(a - 1) + fibonacci(a - 2)

  print(fibonacci(5))
}
