package chapter3.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.exercises
 * @ author:   whn
 * @ date:     2020-2-26 12:58
 * @ Function:    
 */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    /**
     * 3. 重复前一个练习，不过这一次生成一个新的值交换过的数组。使用for/yield。
     */

    val arr = Array(1, 2, 3, 4, 5, 6)
    val newArr = for (i <- arr.indices) yield {
      if (i < (arr.length - 1) && i % 2 == 0) { // 偶数下标且小于数组长度减1，将相邻位置交换，下一个下标不做操作直接取数。
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp
      }
      arr(i)
    }
    println(newArr.mkString(" "))

  }

}
