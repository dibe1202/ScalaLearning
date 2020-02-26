package chapter3.exercises

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-25 16:57
 * @ Function:    
 */
object Exercise1 {
  def main(args: Array[String]): Unit = {
    /**
     * 1. 编写一段代码，将a设置为一个n个随机整数的数组，要求随机数介于0(包含)和n(不包含）之间。
     */
    println(createRandomArray(10).mkString(" "))
  }

  def createRandomArray(n: Int): Array[Int] = {
    val random = Random.nextInt(n) // 生成一个介于0到n的随机数，不包括n
    val randomArr = new Array[Int](n)
    for (i <- randomArr.indices) randomArr(i) = random
    randomArr
  }
}
