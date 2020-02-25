package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 17:05
 * @ Function:    
 */
object Exercise7 {
  def main(args: Array[String]): Unit = {
    /**
     * 7. 同样是解决前一个练习的问题，但这次不使用循环。(提示:在Scaladoc中查
     * 看StringOps.)
     */

    val res = "Hello".map(_.toLong).product
    println(res)


  }

}
