package chapter4.exercises

import java.io.File
import java.util.Scanner

import scala.collection.mutable.ArrayBuffer

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 15:53
 * @ Function:    
 */
object Exercise2 {
  def main(args: Array[String]): Unit = {
    /**
     * 2. 编写一段程序，从文件中读取单词。用一个可变映射来清点每一个单词出现的
     * 频率。读取这些单词的操作可以使用java.util.Scanner:
     * val in = new java.util.Scanner (new java.io.File("myFile.txt"))
     * while (in.hasNext))处理in.next()
     * 或者翻到第9章看看更Scala的做法。最后，打印出所有单词和它们出现的次数
     */

    val in = new Scanner(new File(".gitignore"))
    val buffer = new scala.collection.mutable.ArrayBuffer[String]()
    while (in.hasNext()) {
      buffer += in.next()
    }
    println(buffer.length)
    val wd1 = buffer
      .map(word => (word, 1))
      .groupBy(_._1)
      .map((tuple: (String, ArrayBuffer[(String, Int)])) => (tuple._1, tuple._2.size))
    wd1.foreach(println)

    val wd2 = buffer
      .map(word => (word, 1))
      .groupBy(_._1) // 返回Map[A,B]
      //    override def mapValues[C](f: B => C): Map[A, C] = new MappedValues(f) with DefaultMap[A, C]
      .mapValues(_.size) // 处理上一步groupBy后的values即[B]， 传入一个处理集合B的的函数(B=>C)得到集合C，最终返回[A,C]
    wd2.foreach(println)


  }

}
