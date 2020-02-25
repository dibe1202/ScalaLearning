package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 16:56
 * @ Function:    
 */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    /**
     * 5. 编写一个过程countdown(n: Int)，打印从n到0的数字。
     */
    countdown(10)
  }

  def countdown(n: Int): Unit = {
    for (i <- (0 to n).reverse) println(i)
  }

}
