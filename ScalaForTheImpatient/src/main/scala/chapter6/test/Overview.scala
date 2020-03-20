package chapter6.test

import java.awt.Point


/**
 * @ project:  Scalalearning
 * @ package:  chapter6.test
 * @ author:   whn
 * @ date:     2020-3-18 10:08
 * @ Function: 第六章 对象
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /**
     * 主要内容：
     *   1. 用对象作为单例或存放工具方法。
     *   2. 类可以拥有一个同名的伴生对象。
     *   3. 对象可以扩展类或特质。
     *   4. 对象的apply方法通常用来构造伴生类的新实例。
     *   5. 如果不想显式定义main方法，可以用扩展App 特质的对象。
     *   6. 你可以通过扩展Enumeration 对象来实现枚举。
     */

    val arr = new Array(100)
    val arr1 = Array(100)
    val point = new Point(1,2)
    println(point.x,point.y)


  }
}
