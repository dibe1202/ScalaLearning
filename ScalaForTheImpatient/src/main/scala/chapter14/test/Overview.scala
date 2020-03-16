package chapter14.test

import java.io.IOException
import java.net.{MalformedURLException, URL}

/**
 * @ project:  Scalalearning
 * @ package:  chapter14.test
 * @ author:   whn
 * @ date:     2020-3-9 12:13
 * @ Function:    
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /**
     * 第14章 模式匹配与样例类
     *
     * 与switch语句不同， Scala模式匹配并不会有“意外掉入下一个分支”的问题。
     * （在C和其他类C语言中，你必须在每个分支的末尾显式地使用break语句来退出
     * switch，否则将掉入下一个分支。这很烦人，也容易出错。）
     * 模式总是自上而下进行匹配。
     */

    var sign = 0
    val ch: Char = '+'

    // 1.基本语法
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ => sign = 0
    }

    // 2.模式匹配也是表达式而不是语句，代码可以简化为
    sign = ch match {
      case '+' => 1
      case '-' => -1
      case _ => 0
    }
    // 3. 用 | 表示或的匹配
    ch match {
      case '+' | '-' => 1
      case _ => 0
    }

    // 4. 添加守卫
    ch match {
      case _ if Character.isDigit(ch) => "digit"
      case _ => "others"
    }

    // 5. 在模式匹配中使用变量

    val arr = Seq('+', '-', '1')
    val res = arr.map {
      case temp if (Character.isDigit(temp)) => "char"
      case _ => "others"
    }
    // 6. 匹配类型，对表达式的类型进行匹配
    val seq = Seq(1, 2, "aa", 2.5, 'c')
    val res1 = seq.map({
      case a: Int => a + 1
      case b: String => "str"
      // 匹配类型时,必须给出一个变量名，否则匹配的是对象本身.
      case _: Double => 0.0 // 匹配任何 类型为Double的对象
//      case Double => "double" // 匹配 类型为Class的Double对象
      case _ => "others"
    })
    // 7. 用模式匹配处理异常
    val url = new URL("http://horstmann.com/fred-tiny.gif")
    try {
      url.getPath
    } catch {
      case _: MalformedURLException => println(s"Bad URL$url")
      case ex: IOException => ex.printStackTrace() // 更通用的异常排在更具体的异常之后
    }

    val arr1 = Array(Array(0, 1), Array(2, 3), Array(0, 1, 2, 3, 4, 5, 6), Array(1, 2, 3, 4), Array(1))
    // 8. 匹配数组
    arr1.map({
      case Array(1) => "0"
      case Array(x, y) => x + y
      case Array(0, _*) => "0 ...."
      case Array(x, rest@_*) => rest.min
      case _ => "others"
    }).foreach(println)

    // 9. 匹配Map
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
    for ((k, v) <- map) println(k + "===" + v)
  }
}
