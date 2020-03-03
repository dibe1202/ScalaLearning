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
  }
}

class Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]  // 每个成员自己的联系人组
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





