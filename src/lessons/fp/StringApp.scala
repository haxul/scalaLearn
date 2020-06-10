package lessons.fp

object StringApp extends App {

  class StringFormatter(str: String) {
    def flatMap(f: String => StringFormatter): StringFormatter = f(str)

    def fold(f: String => String): String = f(str)
  }

  object StringFormatter {
    def apply(str: String): StringFormatter = new StringFormatter(str)
  }

  val s = StringFormatter(null)
    .flatMap(s => StringFormatter(s.toUpperCase()))
    .flatMap(s => StringFormatter(s.replace(" ", "!!!")))
    .fold(s => s)
  println(s)
}
