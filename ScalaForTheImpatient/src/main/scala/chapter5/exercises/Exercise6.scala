package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 15:26
 * @ Function:    
 */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    /**
     * 6. 在5.1节的Person类中提供一个主构造器，将负年龄转换为0。
     */

    val whn = new Person3(10)
    println(whn.age)
    whn.age = -10
    println(whn.age)
  }
}

class Person3(private var privateAge: Int) {
  def age_=(newValue: Int) {
    if (newValue < 0) {
      this.privateAge = 0
    } else {
      this.privateAge = newValue
    }
  }

  def age: Int = privateAge
}
