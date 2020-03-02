package chapter2.test

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.test
 * @ author:   whn
 * @ date:     2020-2-24 14:50
 * @ Function:    
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /** **
     * 1. 在本章中，你将学到如何在Scala 中使用条件表达式、循环和函数。你会看到Scala
     * 和其他编程语言之间的一个根本性差异。在Java或C++中，我们把表达式（比如3+4）
     * 和语句（比如if语句）看作两样不同的东西。表达式有值，而语句执行动作。在Scala
     * 中，几乎所有构造出来的语法结构都有值。这个特性使得程序更加精简，也更易读。
     */
    val x = -10
    // if和else分支的返回值是同一种类型，最后的返回值即为该类型。
    val res1: Int = if (x > 0) 1 else 0
    println(res1)
    // if和else分支的返回值如果不是同一种类型，最后的返回值为两个分支类型的超类。
    val res2: Any = if (x > 0) 1 else "invalid"
    println(res2)
    // 如果只有if分支， 实际上else分支的返回类型为Unit，最后的返回值类型为AnyVal
    // 将Unit当做java的void，不同的是void代表没有值而Unit表示一个“无值”的值
    val res3: AnyVal = if (x > 0) 1 // else ()

    /** **
     * 2. scala对于不返回值的函数有特殊的表示方法，如果函数体包含在花括号当中但没有
     * 前面的＝号，那么返回类型就是Unit。这样的函数被称作过程（procedure）
     * def box(s : String){              ／／仔细看：没有＝号
     *    val border = "-" * (s.length + 2)
     *    print(f"$border%n|$s|%n$border%n")
     * }
     *
     * 但通常过程的定义可以显示的把Unit类型写出
     * def box(s: String): Unit = {
     *    ....
     * }
     */
    val s = "haha"
    val border = "-" * (s.length + 2)
    print(f"$border\n|$s|\n$border\n") // \n和%n都可以表示换行
  }

}
