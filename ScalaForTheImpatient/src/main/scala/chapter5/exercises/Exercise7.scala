package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 15:35
 * @ Function:    
 */
object Exercise7 {
  def main(args: Array[String]): Unit = {
    /**
     * 7. 编写一个Person类，其主构造器接受一个字符串，该字符串包含名字、空格和姓，比如
     * new Person("Fred Smith"）。提供只读属性firstName和lastName。
     * 主构造器参数应该是var、val 还是普通参数呢？为什么？
     *
     * A: 主构造器参数应该是val，因为名字一旦创建就没有直接修改的必要。
     */

    val whn = new Person4("Wang HuaNan")
    println(whn.firstName)
    println(whn.lastName)

  }
}

class Person4(val name:String){
  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)
}


