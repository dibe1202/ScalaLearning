package chapter6.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter6.exercises
 * @ author:   whn
 * @ date:     2020-3-18 14:03
 * @ Function:    
 */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    import Suits._
    println(Spade.toString)
    println("♣")
    println("\u2663")

    val p1 = new Person10
    val p2 = new People10
    val ss = Seq(p1, p2)
    ss.map({
      case x: People10 => "people"
      case y: Person10 => "Person"
    }).foreach(println)


  }
}

object Suits extends Enumeration {
  type Suits = Value
  val Spade = Value("♣")
  val Club = Value("♦")
  val Heart = Value("♥")
  val Diamond = Value("♠")

}

class Person10 {

}

class People10 {

}

