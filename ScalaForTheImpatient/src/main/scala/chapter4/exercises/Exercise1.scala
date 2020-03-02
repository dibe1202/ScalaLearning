package chapter4.exercises

import scala.collection.mutable

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 15:44
 * @ Function:    
 */
object Exercise1 {
  def main(args: Array[String]): Unit = {
    /**
     * 1. 设置一个映射，其中包含你想要的一些装备及其价格。然后构建另一个映射，
     * 采用同一组键，但在价格上打9折。
     */

    val map = Map("AJ1" -> 1000, "AJ2" -> 800, "AJ11" -> 2000)
    val newMap = for ((k, v) <- map) yield (k, v * 0.9)
    newMap.foreach(println)

  }
}
