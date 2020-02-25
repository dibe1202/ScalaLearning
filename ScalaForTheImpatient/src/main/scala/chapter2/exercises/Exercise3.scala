package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 16:45
 * @ Function:    
 */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    /**
     *  3. 指出在Scala中何种情况下赋值语句x=y=1是合法的。（提示：给x找个合适的类型定义。）
     *
     * A: scala中赋值语句的返回值类型为unit， 即y=1返回unit，所以x=y=1时，当你需要将
     * Unit赋值给一个变量时该语句有效。 通常我们不会这么做，毫无意义
     */
    var y = 0
    val x = y = 1
    println(x)
  }

}
