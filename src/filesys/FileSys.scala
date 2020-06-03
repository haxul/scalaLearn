package filesys
import java.util.Scanner

import scala.language.postfixOps

object FileSys extends App {
  
  val scanner:Scanner = new Scanner(System.in)

  while(true) {
    print("$ ")
    val command: String = scanner.nextLine()
    if (command equals "\\q") System.exit(0)
    println(command)
  }
}
