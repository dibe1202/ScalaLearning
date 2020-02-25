package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 16:28
 * @ Function:    
 */
object Exercise1 {
  def main(args: Array[String]): Unit = {
    /**
     * 1. 一个数字如果为正数，则它的signum为1 ；如果是负数，则signum为-1 ；如果是
     * 0，则signum为0。编写一个函数来计算这个值。
     */

    println(fun1(1))
    println(fun1(-1))
    println(fun1(0))

  }

  def fun1(num: Int): Int = {
    if (num > 0) 1
    else if (num < 0) -1
    else 0 // else(num == 0)
  }
}
