package chapter1.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter1.exercise
 * @ author:   whn
 * @ date:     2020-2-24 14:14
 * @ Function:    
 */
object Exercise10 {
  def main(args: Array[String]): Unit = {
    /****
     * 10.  take 、drop 、takeRight 和dropRight 这些字符串方法是做什么用的？和
     * substring相比，它们的优点和缺点都有哪些？
     *
     * A:
     *   def take(n: Int): String    // Selects first n elements.
     *   def drop(n: Int): String    // Selects all elements except first n ones.
     *   def takeRight(n: Int): String  // Selects last n elements.
     *   def dropRight(n: Int): String   // Selects all elements except last n ones.
     * 如上的四个方法都是单向求取其中的子字符串，如果需要求中间的字符，则需要用两个函数结合起来，没有subString灵活。
     */

    val str = "HelloScala"
    println(str.take(1))
    println(str.drop(2))
    println(str.takeRight(1))
    println(str.dropRight(2))
  }
}
