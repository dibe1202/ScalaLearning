package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 17:16
 * @ Function:    
 */
object Exercise9 {
  def main(args: Array[String]): Unit = {
    /**
     * 9. 把前一个练习中的函数改成递归函数。
     */
    println(recurProduct("Hello")) // 9415087488

    // 原函数
    def myProduct(str: String): Long = {
      val res = str.map(_.toLong).product
      res
    }

    // 递归实现
    def recurProduct(str: String): Long = {
      if (str.length == 0) 1   // 递归终止条件, 最后一个字符"l".tail的结果为空字符串"".
      else str.head.toLong * recurProduct(str.tail)
    }
  }
}
