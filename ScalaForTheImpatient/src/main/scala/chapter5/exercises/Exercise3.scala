package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 14:30
 * @ Function:    
 */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    /**
     * 3. 编写一个Time类，加人只读属性hours和minutes，以及一个检查某一时刻是否早于另一时刻的方法before(other: Time):Boolean。
     * Time对象应该以new Time(hrs,min)方式构建，其中hrs小时数以军用时间格式呈现（介于0和23之间）。
     */

    val t1 = new Time(2,10)
    val t2 = new Time(3,10)
    println(t1.toString)
    println(t1.before(t2))
  }
}

class Time(val hrs: Int, val mins: Int) {
  def before(other: Time): Boolean = { // true，小于other
    hrs < other.hrs || (hrs == other.hrs && mins < other.mins)
  }

  override def toString: String = {
    hrs + ":" + mins
  }
}
