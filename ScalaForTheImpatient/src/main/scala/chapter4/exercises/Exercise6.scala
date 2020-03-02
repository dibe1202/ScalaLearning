package chapter4.exercises
import scala.collection.mutable

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 17:07
 * @ Function:    
 */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    /**
     * 6. 定义一个链式啥希映射，将"Monday"映射到java.util.Calendar.MONDAY,
     * 依此类推加入其他日期。展示元素是以插入的顺序被访问的。
     */
    val xs = java.util.Calendar.MONDAY
    val linkedMap: mutable.LinkedHashMap[String, Int] = scala.collection.mutable.LinkedHashMap[String,Int]()
    linkedMap += "Monday" -> java.util.Calendar.MONDAY // 星期日为1，依次2,3,4,5,6,7
    linkedMap += "Wednesday" -> java.util.Calendar.WEDNESDAY
    linkedMap += "Sunday" -> java.util.Calendar.SUNDAY
    linkedMap += "Tuesday" -> java.util.Calendar.TUESDAY
    linkedMap.foreach(println)
  }

}
