package chapter12.test

import scala.math._

/**
 * @ project:  Scalalearning
 * @ package:  chapter12.test
 * @ author:   whn
 * @ date:     2020-3-9 9:59
 * @ Function:    
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /**
     * 第十二章  高阶函数
     * Scala混合了面向对象和函数式的特性。在函数式编程语言中，函数是"头等公民”
     *    1.可以赋值给一个变量。
     *    2.可以作为参数传递给另一个函数。
     *    3.函数可以返回一个函数。
     */

    // 1.将函数赋值给一个变量
    def fun(x: Int): Int = {
      x + 1
    }
    val fun1 = fun _ // _意味着指的是这个函数，而不是忘记传参
    fun1(1)

    val fun2: Int => Int = fun // 如果指明了变量类型，则不需要加_

    // 2.将类的方法转变为函数
    val res = "DD".charAt(0) // 返回字符串的第n个char
    val fun3: (String, Int) => Char = (_: String).charAt(_: Int) // 指定参数类型,会自动推断出函数类型为（String, Int） => Char
    fun3("DD",0)

    val fun4: (String, Int) => Char = _.charAt(_) // 指明函数类型，则不用指定参数类型。
    println(fun4("Hello", 2))

    // 3. 将函数传递给其他接受函数参数的方法
    val arr = Array(1, 2, 3, 4, 5)
    arr.map(
      (xs: Int) => {
      xs + 1
    })
    val res1 = arr.map(fun1) // 将函数fun1传递给map方法，也可以传方法fun，scala内部会将该方法转变为函数传递。

    // 4. 匿名函数
    arr.map(xs => xs + 1) // xs => xs + 1就是一个匿名函数

    // 5. 带函数参数的函数
    // 可以接受函数参数的方法或函数，称为高阶函数
    def fun5(f: (Double) => Double): Double = {
      f(0.25)
    } // 该方法的参数是一个函数类型为Double => Double的函数f,返回一个函数表达式f(0.25)


    val fun6: (Double => Double) => Double = (f: (Double) => Double) => f(0.25) // 该函数的参数是一个函数类型为Double => Double的函数f,返回一个函数表达式f(0.25)
    // 高阶函数也可以返回一个函数

    def mulBy(factor: Double) = {
      x: Double => factor * x // 返回了一个匿名函数
    }

    val res2: Double => Double = mulBy(2)

    res2(5)
    val res3: Double = mulBy(2)(5)


    //6. 参数类型推断
    fun5(xs => xs + 1)
    fun5(_ + 1) // 如果参数在方法体只出现一次，则可以用_省略
    fun5(xs => { // xs在方法体使用了两次，不能用_替代
      val temp = xs + 1
      xs * 2
    })
    // 7. 常见的高阶函数  map、filter、reduce等等

    val arr10 = new Array[String](5)
    val arr11 = new scala.collection.mutable.ArrayBuffer[Int]()
    arr11 += 1
    arr11 += (1,2,3,4,5)
    arr11 ++= Array(1,2)
    val list1 = List(1,2,3,34,5)
    val list2 = 1::2:: Nil

    val tuple = (1,"2",'c',4,54,5,Array(1,2,3,4))

    val map: Map[String, Int] = Map(("a",1),("b",2))
    val map1 = Map("a" -> 1,"b"->2)
for((k,v) <- map1){
  println(k,v)
}








    arr11.foreach(println)


  }

}
