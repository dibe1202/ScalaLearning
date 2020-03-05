package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 16:10
 * @ Function:    
 */
object Exercise10 {
  def main(args: Array[String]): Unit = {
    /**
     * 10. class Employee (var name: String, var salary : Double) {
     * def this () { this ("John Q. Public", 0.0 ) }
     * 练习重写该类，使用显式的宇段定义和一个默认主构造器。你更倾向于使用哪一种形式？为什么？
     *
     *
     * A: 倾向上面的方式， 如果需要提供字段默认值，第一种方式可以直接在创建对象的时候传入字段值，不传则默认值。
     * 第二种方式，创建对象的时候不能传参。
     */

    val em1 = new Employee1("whn", 20000)
    println(em1.name)
    val em2 = new Employee2()
    println(em2.name)
    em2.name = "cjj"
    em2.salary = 100000
    println(em2.name)

  }

}

class Employee1(val name: String, var salary: Double) {
  def this() {
    this("John Q. Public", 0.0)
  }
}

class Employee2 {
  var name: String = "John Q. Public"
  var salary: Double = 0.0
}

