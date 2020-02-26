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
    if (arr.length % 2 == 0) { // 数组长度为偶数
      for (i <- arr.indices by 2) {
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp
      }
    }
    else { // 数组长度为奇数时，最后一位不变。
      for (i <- 0 until arr.length - 1 by 2) {
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp
      }
    }
    println(arr.mkString(" "))
  }


}
