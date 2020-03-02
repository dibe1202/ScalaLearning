package chapter4.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 17:28
 * @ Function:    
 */
object Exercise8 {
  def main(args: Array[String]): Unit = {
    /**
     * 8. 编写一个函数minmax(values:Array[Int]),返回数组中最小值和最大值的对偶。
     */

    println(minmax(Array(1, 2, 3, 4, 56, 7)))

  }

  def minmax(arr: Array[Int]): (Int, Int) = {
    val min = arr.min
    val max = arr.max
    (min, max)
  }

}
