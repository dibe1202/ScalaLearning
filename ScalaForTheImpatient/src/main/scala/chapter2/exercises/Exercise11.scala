package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 18:01
 * @ Function:    
 */
object Exercise11 {
  def main(args: Array[String]): Unit = {
    /**
     * 11. 定义一个名为date的字符串插值器，通过这样一个插值器，你可以以 date"$year-$month-$day"的形式来定义java.time.LocalDate。
     * 你需要定义一个带有date方法的“隐式”类，就像这样：
     *    implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
     *        def date(args: Any*): LocalDate = ...
     *    }
     * args(i)是第i个表达式的值。将每个表达式转换成字符串，然后再转换成整数，并传递给LocalDate.of方法。如果你已经会一些Scala,
     * 就再加上错误处理逻辑。如果没有三个入参，或者入参不是整数，或者它们不是以破折号隔开的，则抛出异常。
     * (你可以用sc.parts来获取表达式之间的字符串.)
     */
  }

}
