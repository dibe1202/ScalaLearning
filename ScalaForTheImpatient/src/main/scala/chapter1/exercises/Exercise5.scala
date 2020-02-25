package chapter1.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chap1.exercise
 * @ author:   whn
 * @ date:     2020-2-24 11:17
 * @ Function:    
 */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    /****
     * 5. 10 max 2 的含义是什么？ max方法定义在哪个类中？
     *
     * A: 可以写成10.max(2), 含义是取10和2的最大值。
     * 该方法实际定义在ScalaNumberProxy中，由RichInt继承该类实现， Int隐式转换为RichInt调用该方法。
     *
     * def max(that: Int): Int
     * Returns this if this > that or that otherwise.
     *
     * Implicit information
     * This member is added by an implicit conversion from Int to RichInt performed by method intWrapper in scala.LowPriorityImplicits.
     * Definition Classes
     * RichInt → ScalaNumberProxy
     */

    //    scala> 10 max 2
    //    res6: Int = 10

  }
}
