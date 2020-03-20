package chapter6.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter6.exercises
 * @ author:   whn
 * @ date:     2020-3-18 13:39
 * @ Function:    
 */
object Exercise4 {
  val p1 = new Point(1, 2)
  println(p1.x, p1.y)
  val p2 = Point(3, 4)
  println(p2.x, p2.y)

}

class Point(val x: Int, val y: Int) {
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}
