package chapter3.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-26 11:06
 * @ Function:    
 */
object Exercise2 {
  def main(args: Array[String]): Unit = {
    /**
     * 2. 编写一个循环，将整数数组中相邻的元素置换。例如，Array(1,2,3,4,5)经过置换后变为Array(2,1,4,3,5)。
     */
    val arr = Array(1, 2, 3, 4, 5)
    // 只能取到（数组长度-2)/2 + 1 个坐标，
    // 比如当坐标为奇数5时， 取到0，2下标, 这样只需交换(0,1)和（2,3）位置的数据，最后一位(4)保持不变
    // 当坐标为偶数6时，取到0，2，4下标，这样就交换(0，1),(2，3),(4，5)的数据。
    // 所以不管数组长度为多少，均能实现该功能。
    for (i <- 0 until arr.length - 1 by 2) {
      val temp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = temp
    }
    println(arr.mkString(" "))
  }
}
