package chapter3.exercises

import scala.collection.mutable.ArrayBuffer

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-27 14:35
 * @ Function:    
 */
object Exercise4 {
  def main(args: Array[String]): Unit = {
    /**
     * 4. 给定一个整数数组，产出一个新的数组，包含元数组中的所有正值，以原有顺
     * 序排列；之后的元素是所有零或负值，以原有顺序排列.
     */

    val arr = Array(1, 2, -3, 5, 2, -1, 0, 11, -2)

    val arrBuffer = new ArrayBuffer[Int]()
    for (i <- arr if i > 0) yield arrBuffer += i
    for (i <- arr if i == 0) yield arrBuffer += i
    for (i <- arr if i < 0) yield arrBuffer += i

    println(arrBuffer.mkString(" "))


  }

}
