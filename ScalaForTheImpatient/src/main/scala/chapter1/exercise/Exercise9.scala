package chapter1.exercise

/**
 * @ project:  Scalalearning
 * @ package:  chapter1.exercise
 * @ author:   whn
 * @ date:     2020-2-24 14:08
 * @ Function:    
 */
object Exercise9 {
  def main(args: Array[String]): Unit = {
    /****
     * 9.在Scala 中如何获取字符串的首字符和尾字符？
     */

    val str = "HelloScala"
    val headStr = str.head
    val lastStr = str.last
    val tailStr = str.tail
    println(headStr) // H
    println(lastStr) // a
    println(tailStr) // elloScala
  }
}
