package chapter3.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-27 16:39
 * @ Function:    
 */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    /**
     * 5. 如何计算Array[Double］的平均值？
     */

    val arr = Array(0.1, 0.2, 3.2, 2.5)
    val average = arr.sum / arr.length
    println(average)
  }

}
