package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 16:51
 * @ Function:    
 */
object Exercise4 {
  def main(args: Array[String]): Unit = {
    /**
     * 4. 针对下列Java循环编写一个Scala版：
     * for(int i = 10 ; i >= 0; i--) System.out.println(i);
     */

    // 方法1:
    for (i <- (0 to 10).reverse) println(i)
    // 方法2:
    for (i <- (0 to 10); j = 10 - i) println(j)
  }

}
