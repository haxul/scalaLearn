package Implicits

object TypesClasses extends App {

  class Equal(implicit value: String) {
    def toUp(): String = value.toUpperCase
  }

  implicit val string: String = "hello world"

  val eq:Equal = new Equal




}
