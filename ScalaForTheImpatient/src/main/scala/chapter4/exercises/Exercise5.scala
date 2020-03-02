package chapter4.exercises

import scala.io.Source

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 16:56
 * @ Function:    
 */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    /**
     * 5. 重复前一个练习，这次用java.util.TreeMap并使之适用于ScalaAPI 。
     */

    val buffer = Source.fromFile(".gitignore")
    val res = buffer
      .getLines()
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .toArray
      .groupBy(_._1)
      .mapValues(_.length)
    val treeMap = new java.util.TreeMap[String, Int]()
    for ((k, v) <- res) {
      treeMap.put(k, v)
    }
    import scala.collection.JavaConversions.mapAsScalaMap
    val scalaMap: scala.collection.mutable.Map[String, Int] = treeMap
    scalaMap.foreach(println)  // foreach是scala映射的方法， 通过隐式转换，将java.util.TreeMap => scalaMap
  }

}
