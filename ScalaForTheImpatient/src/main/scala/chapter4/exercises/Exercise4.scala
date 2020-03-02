package chapter4.exercises

import scala.io.Source

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 16:35
 * @ Function:    
 */
object Exercise4 {
  /**
   * 4. 重复前一个练习，这次用已排序的映射，以便单词可以按顺序打印出来。
   */
  def main(args: Array[String]): Unit = {
    val buffer = Source.fromFile(".gitignore")
    val res = buffer
      .getLines()
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .toArray
      .groupBy(_._1)
      .mapValues(_.length)
    var sortedMap = scala.collection.SortedMap[String, Int]()
    for ((k, v) <- res) {
      sortedMap += (k -> v)
    }

    sortedMap.foreach(println)

  }


}
