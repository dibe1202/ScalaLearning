package chapter4.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 17:30
 * @ Function:    
 */
object Exercise9 {
  def main(args: Array[String]): Unit = {
    /**
     * 9. 编写一个函数lteqgt(values:Array[Int], v:Int)，返回数组中小于v、等于v和大于v的数量，要求三个值一起返回。
     */
    lteqgt(Array(1, 2, 3, 4, 5, 6, 67, 7, 8, 89), 5)
  }

  def lteqgt(arr: Array[Int], v: Int) = {
    val lessV = arr.count(_ < v)
    val equalV = arr.count(_ == v)
    val overV = arr.count(_ > v)
    (lessV, equalV, overV)
  }
}
