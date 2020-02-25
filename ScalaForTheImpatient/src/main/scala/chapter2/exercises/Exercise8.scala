package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 17:14
 * @ Function:    
 */
object Exercise8 {
  def main(args: Array[String]): Unit = {
    /**
     * 8. 编写一个函数product (s: String)，计算前面练习中提到的乘积。
     */

    println(myProduct("Hello"))

    def myProduct(str: String): Long = {
      val res = str.map(_.toLong).product
      res
    }
  }
}
