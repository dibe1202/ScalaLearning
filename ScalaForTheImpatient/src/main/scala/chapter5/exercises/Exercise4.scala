package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 14:42
 * @ Function:    
 */
object Exercise4 {
  def main(args: Array[String]): Unit = {
    /**
     * 4. 重新实现前一个练习中的Time类，将内部呈现改成自午夜起的分钟数(介于0到24×60-1之间)。
     * 不要改变公有接口。也就是说，客户端代码不应因你的修改而受到影响。
     */

    val t1 = new Time1(10, 20)
    println(t1.toString)
  }
}

class Time1(val hrs: Int, val mins: Int) {
  def before(other: Time): Boolean = { // true，小于other
    hrs < other.hrs || (hrs == other.hrs && mins < other.mins)
  }

  override def toString: String = {
    hrs * 60 + mins + ""
  }
}
