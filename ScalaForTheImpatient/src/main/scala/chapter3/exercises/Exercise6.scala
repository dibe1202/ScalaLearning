package chapter3.exercises

import scala.collection.mutable.ArrayBuffer

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-27 16:42
 * @ Function:    
 */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    /**
     * 6.如何重新组织Array[Int]的元素将它们以反序排列？对于ArrayBuffer[Int]
     * 你又会怎么做呢？
     */

    val arr = Array(1, 2, 3, 4, 5, 6)
    val res1 = arr.reverse // 逆序后生成一个新的数组
    println(res1.mkString(" "))

    val arrBuffer = ArrayBuffer(1, 2, 3, 4, 5, 6)
    val res2 = arrBuffer.reverse
    println(res2.mkString(" "))

  }
}
