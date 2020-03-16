package chapter2.test

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.test
 * @ author:   whn
 * @ date:     2020-2-24 14:50
 * @ Function: 第二章 控制结构和函数
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

    /**
     * 2. 高级For循环
     */

//    val arr1 = Array(1, 2, 3, 4, 5)
//    // 基本for循环
//    for (i <- arr1) {
//      println(i)
//    }
//    for (i <- 1 to arr1.length) println(i)
//    arr1.indices
//    for (i <- 1 until arr1.length) println(i)
//    for (i <- 1 to 10 by -1) println(i) // 逆序
//    for (i <- 1 to 10 by 2) println(i) // 步长为2
//    for (i <- 10 to 1 by -2) println(i) // 逆序, 步长为2
//    for(i<- (1 to 10).reverse)
//    for (i <- Range(1, 10)) println(i)
//    for (i <- Range(1, 10).reverse) println(i) // 逆序
//    for (i <- Range(1, 10, 2).reverse) println(i) // 步长为2
//    for (i <- Range(10, 1, -2)) println(i) // 逆序，步长为2
    // 高级for循环
//    for (i <- 1 to 3; j <- 1 to 3) println(i + j) // 双层循环
    for (i <- 1 to 10 if i % 2 == 0) println(i) // 带if守卫的循环
    for (i <- 1 to 10; from = 4 - i; j <- from to 3) println(i + j) // 可以使用任意多的定义，引入可以在循环中使用的变量
    val newArr: Seq[Int] = for (i <- 1 to 10 if i % 2 != 0) yield i //for推导式，会构造出一个新的集合，每次迭代生成集合中的一个值。


    /** **
     * 3. scala对于不返回值的函数有特殊的表示方法，如果函数体包含在花括号当中但没有
     * 前面的＝号，那么返回类型就是Unit。这样的函数被称作过程（procedure）
     * def box(s : String){              ／／仔细看：没有＝号
     * val border = "-" * (s.length + 2)
     * print(f"$border%n|$s|%n$border%n")
     * }
     *
     * 但通常过程的定义可以显示的把Unit类型写出
     * def box(s: String): Unit = {
     * ....
     * }
     */
    val s = "haha"
    val border = "-" * (s.length + 2)
    print(f"$border\n|$s|\n$border\n") // \n和%n都可以表示换行

    /**
     * 4. 函数和方法的区别
     */
    // 1.定义方法不同
    def me1(a: Int, b: Int): Int = a + b // 方法用def
    val fun1: (Int, Int) => Int = (a: Int, b: Int) => a + b // 函数用val
    // 2.参数列表是否可以为空
    def me2: Int = 10 // 方法的参数列表可以为空，可以这样写
    def me3(): Int = 10 //
    val fun2: () => Int = () => 10 // 方法参数列表可以为空，但不能省略()
    // 3.函数可以作为参数传递，函数是可以作为参数传递，函数名只是代表函数自身；
    // 方法不能作为参数传递，用的方法名的地方意味这调用，那为什么在需要函数出现的地方
    // 我们可以提供一个方法，在scala中很多高级函数，如map(),filter()等，都是要求
    // 提供一个函数作为参数，这是因为，如果期望出现函数的地方我们提供了一个方法的话，
    // 该方法就会自动被转换成函数。
    def fun3(a: Int): Int = a + 1
    Range(1, 10).map(fun3) // 这里将方法fun3自动转换为函数传递给高阶函数map
    val list: List[Int] = List(1,2,3)


    def fun5(a:Int,b:Int):Int ={
      a + b
    }

    val fun6: (Int, Int) => Int = (a, b) => a + b
    val fun7: () => Int = () => 1


  }


}
