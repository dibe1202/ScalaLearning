package chapter5.test

import scala.collection.mutable.ArrayBuffer


/**
 * @ project:  Scalalearning
 * @ package:  chapter5.test
 * @ author:   whn
 * @ date:     2020-3-3 14:41
 * @ Function:    
 */
object NestedClassTest {

  /**
   * 5.8 在Scala中，你几乎可以在任何语法结构中内嵌任何语法结构。你可以在函数中定义函数，在类中定义类。
   */

  def main(args: Array[String]): Unit = {
    // java中，内部类从属于外部类
    // scala中每个实例都有自己的Member类，chatter.Member和myFace.Member是不同的两个类
    val chatter = new Network
    val myFace = new Network

    // 可以在各自的网络中添加成员，不能跨网络添加
    val fred: chatter.Member = chatter.join("Fred") // 将Fred添加到chatter网络
    val wilma: chatter.Member = chatter.join("Wilma") // 将wilma添加到chatter网络
    fred.contacts += wilma // OK，同一网络，可以实现将wilma添加到fred的联系人中。

    val barney: myFace.Member = myFace.join("Barney") // 类型为myFace.Member
    //    fred.contacts += barney // 不能实现---不能够将myFace.Member添加到不同网络的chatter.Member的元素集合中。

    // 伴生对象解决方案:
    val net1 = new Network1
    val net2 = new Network1
    val whn: Network1.Member = net1.join("WHN")
    val cjj: Network1.Member = net2.join("CJJ")
    whn.contacts += cjj // 可以实现将不同网络的元素添加到一个彼此集合中

    // 类型投影解决方案:
    val net3 = new Network2
    val net4 = new Network2
    val spark: Network2#Member = net3.join("spark")
    val hive: Network2#Member = net4.join("hive")
    spark.contacts += hive // 类型投影Network2#Member表示任何Network2对象的Member
  }
}

class Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member] // 每个成员自己的联系人组
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

/**
 * 如果想要实现上面的不同网络的成员互相添加场景，有两种解决方法：
 *  1. 可以将Member类定义在Network的伴生对象中
 *  2. 使用类型投影
 */

/**
 * 方案1
 */

object Network1 {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]()
  }

}


class Network1 {
  private val members = new ArrayBuffer[Network1.Member]

  def join(name: String): Network1.Member = {
    val m = new Network1.Member(name)
    members += m
    m
  }
}

/**
 * 方案2
 * 使用类型投影（ type projection ) Network#Member ，其含义是“任
 * 何Network的Member
 */

class Network2 {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network2#Member] // 每个成员自己的联系人组
  }

  private val members = new ArrayBuffer[Network2#Member]

  def join(name: String): Network2#Member = {
    val m = new Member(name)
    members += m
    m
  }
}

/**
 * 在嵌套类中，你可以通过外部类.this 的方式来访问外部类的this引用，就像Java那样。如果你觉得需要，
 * 也可以用如下语法建立一个指向该引用的别名
 */

class Network3 {
  outer =>
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member] // 每个成员自己的联系人组
//    def description = s"$name inside ${outer.name}"
  }
}







