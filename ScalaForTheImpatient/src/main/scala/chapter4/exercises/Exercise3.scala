package chapter4.exercises

import java.io.File
import java.util.Scanner

import scala.io.Source

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 16:19
 * @ Function:    
 */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    /**
     * 3. 重复前一个练习，这次用不可变的映射。
     */

    val buffer = Source.fromFile(".gitignore")
    val res = buffer
      .getLines()
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .toArray
      .groupBy(_._1)
      .mapValues(_.length)
    res.foreach(println)

  }

}
