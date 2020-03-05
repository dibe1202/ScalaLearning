package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 15:42
 * @ Function:    
 */
object Exercise8 {
  def main(args: Array[String]): Unit = {
    /**
     * 8. 创建一个Car类，以只读属性对应制造商、型号名称、型号年份以及一个可读写的属性用于车牌。
     * 提供四组构造器。每一个构造器都要求制造商和型号名称为必填。型号年份以及车牌为可选，如果未填，
     * 则型号年份设置为－1 ，车牌设置为空字符串。你会选择哪一个作为你的主构造器？为什么？
     *
     * A: 选择(制造商和型号名称)为主构造器， 因为必填。
     */

    val car1 = new Car("奔驰", "C")
    println(car1.toString)
    val car2 = new Car("奥迪", "A6", 2020)
    println(car2.toString)
    val car3 = new Car("宝马", "X3", "陕A22222")
    println(car3.toString)
    val car4 = new Car("奔驰", "C200", 2010, "陕A22WW8")
    println(car4.toString)


    val car5 = new Car2("宝马", "X3", plateNum = "陕A88888")
    println(car5.toString)
  }
}

class Car(val vendor: String, val typeName: String) {

  var typeYear: Int = -1
  var plateNum: String = ""

  def this(vendor: String, typeName: String, typeYear: Int) {
    this(vendor, typeName)
    this.typeYear = typeYear
  }

  def this(vendor: String, typeName: String, plateNum: String) {
    this(vendor, typeName)
    this.plateNum = plateNum
  }

  def this(vendor: String, typeName: String, typeYear: Int, plateNum: String) {
    this(vendor, typeName, typeYear)
    this.typeYear = typeYear
    this.plateNum = plateNum
  }

  override def toString: String = {
    "制造商: " + this.vendor + "\n" +
      "型号名称: " + this.typeName + "\n" +
      "型号年份: " + this.typeYear + "\n" +
      "车牌: " + this.plateNum
  }
}

// 用一个主构造器实现上面的代码
class Car2(val vendor: String, val typeName: String, val typeYear: Int = -1, var plateNum: String = "") {
  override def toString: String = {
    "制造商: " + this.vendor + "\n" +
      "型号名称: " + this.typeName + "\n" +
      "型号年份: " + this.typeYear + "\n" +
      "车牌: " + this.plateNum
  }
}
