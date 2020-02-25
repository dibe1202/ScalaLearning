package chapter1.exercises


/**
 * @ project:  Scalalearning
 * @ package:  chapter1.exercise
 * @ author:   whn
 * @ date:     2020-2-24 13:25
 * @ Function:    
 */
object Exercise7 {
  def main(args: Array[String]): Unit = {
    /****
     * 7. 为了在使用probablePrime(lOO,Random）获取随机质数时不在
     * probablePrime和Random之前使用任何限定符，你需要引人什么？
     *
     * A: 导入 import scala.math.BigInt._和scala.util.Random
     */
    import scala.math.BigInt._
    import scala.util.Random
    val res = probablePrime(100, Random)
    println(res)
  }
}
