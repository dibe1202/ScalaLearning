package chapter1.exercise

import scala.math.BigInt.probablePrime
import scala.util.Random

/**
 * @ project:  Scalalearning
 * @ package:  chapter1.exercise
 * @ author:   whn
 * @ date:     2020-2-24 13:54
 * @ Function:    
 */
object Exercise8 {
  def main(args: Array[String]): Unit = {
    /****
     * 8. 创建随机文件名的方式之一是生成一个随机的Bigint 然后将它转换成三十六进
     * 制，交出类似于吨"snvbevtomcj38o06kul"这样的字符串。查阅Scaladoc找到
     * 在Scala 中实现该逻辑的办法。
     *
     * Q: -> 先生成一个随机的BigInt数
     *    -> 然后通过toString(radix)转换成相应进制的字符串格式数据
     */

    val random = probablePrime(100, Random)  // 生成一个随机质数
    println(random.toString(2))   // 变为2进制
    println(random.toString(16))  // 16进制
    println(random.toString(36))  // 36进制

  }
}
