package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 17:00
 * @ Function:    
 */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    /**
     * 6. 编写一个for循环，计算字符串中所有字母的Unicode代码的乘积。举例来说，"Hello"中所有字符的乘积为9415087488L。
     */

    println(printUnicode("Hello")) // 9415087488L
  }

  def printUnicode(str: String): Long = {
    var res: Long = 1
    for (i <- str)
      res *= i
    res
  }
}
