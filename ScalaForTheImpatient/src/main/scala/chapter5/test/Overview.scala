package chapter5.test

import org.apache.hadoop.mapred.Counters.Counter

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.test
 * @ author:   whn
 * @ date:     2020-3-3 9:39
 * @ Function: 第五章 类
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /**
     *
     * 本章的要点包括：
     *  1. 类中的字段自动带有getter方法和setter方法。
     * Scala为每个字段自动生成getter和setter方法昕上去有些恐怖。不过你可以控制这个过程。
     *       a. 如果字段是私有的，getter和setter方法也是私有的。
     *       b. 如果字段是val，则只有getter方法被生成。
     *       c. 如果你不需要任何getter或setter，可以将字段声明为private[this]
     *  2. 你可以用定制的getter/setter方法替换掉字段的定义，而不必修改使用类的客户端一一这就是所谓的“统一访问原则”。
     * 某个模块提供的所有服务都应该能通过统一的表示法访问到，至于它们是通过存储还是通过计算来实现的，从访问方式上应无从获知
     *  3. 用＠BeanProperty注解来生成JavaBeans的getXXX/setXXX方法。
     *  4. 每个类都有一个主要的构造器，这个构造器和类定义"交织"在一起。它的参数直接成为类的字段。主构造器执行类体中所有的语句。
     *  6. 辅助构造器是可选的。它们叫作this 。
     */
    val myCounter = new Counter // 或 new Counter() 通常对改值法加上括号，取值法不用
    myCounter.increment()
    myCounter.increment()
    println(myCounter.current)

    val fred = new Person()
    println(fred.age) // 调用fred.age()
    fred.age = 21 // 调用fred_=(21)
    println(fred.age) // 调用fred.age()

    val whn = new Person1()
    println(whn.age) // 0 初始化
    whn.age = 20
    println(whn.age) // 20
    whn.age = 18
    println(whn.age) // 20 不能变年轻

  }
}

class Counter { // scala中一个源文件可以包含多个类，所有类都是public
  private var value = 0 // 必须初始化字段

  def increment() { // 方法默认是公有的
    value += 1
  }

  def current: Int = value
}

class Person {
  // scala对每个字段都提供getter和setter方法， 默认为公有字段
  // scala中getter和setter 对应为 age 和 age_=
  // 在JVM底层，都生成私有的字段；对公有字段，提供公有的getter和setter方法，私有的则提供私有的方法，
  var age = 0
  /**
   * scala生成面向JVM中的类，反编译后如下：
   * JVM中不允许有"="出现，因此age_=反编译为age_$eq
   *
   * public class Person {
   * private int age = 0;
   *
   * public int age() {
   * return this.age;
   * }
   *
   * public void age_$eq(int x$1) {
   *       this.age = x$1;
   * }
   * }
   */
}

/**
 * 自定义getter和setter方法
 */
class Person1 {
  private var privateAge = 0 // 变成私有字段

  def age: Int = privateAge

  def age_=(newValue: Int): Unit = {
    if (newValue > privateAge) // 不能变年轻
    {
      privateAge = newValue
    }
  }

  /**
   * 反编译：自动生成了私有的privateAge的getter、setter方法， 还有自定义的getter、setter方法
   * public class Person1 {
   * private int privateAge = 0;
   *
   * private int privateAge() {
   * return this.privateAge;
   * }
   *
   * private void privateAge_$eq(int x$1) {
   *    this.privateAge = x$1;
   * }
   *
   * public int age() {
   * return privateAge();
   * }
   *
   * public void age_$eq(int newValue) {
   * if (newValue > privateAge())
   * privateAge_$eq(newValue);
   * }
   * }
   */
}


/**
 * 只带getter的属性
 * 有时候你需要一个只读属性，有getter但没有setter。如果属性的值在对象构建完成后就不再改变，则可以使用val字段。
 */
class Message {
  val timeStamp = java.time.Instant.now()
}

/**
 * 有这样一种应用场景：客户端不能随意改值，但它可以通过某种其他的方式被改变。
 * 上面的Counter类就是一个很好的例子。从概念上讲， counter有一个current属性，当increment方法被调用时更新，
 * 但并没有对应的setter。你不能通过val来实现这样一个属性--因为val永不改变。你需要提供一个私有字段和一个属性的getter方法.
 */

class Counter1 {
  private var value = 0 // 自动生成私有的getter、setter方法
  def increment() { // 定义一个公有的方法，来改变属性值
    value += 1
  }

  def current: Int = value // 自定义一个getter方法，来获取字段值
}

/**
 * 总结一下，在实现属性时你有如下四个选择：(不能实现只写方法)
 * 1. var foo: Scala自动合成一个getter方法和一个setter方法。
 * 2. val foo: Scala自动合成一个getter方法。
 * 3. 由你来定义foo和foo＿＝方法。
 * 4. 由你来定义foo方法。
 */


/**
 * 类私有字段
 *
 * 在Scala中（在Java或C++中也一样），方法可以访问该类的所有对象的私有字段。
 */

/**
 * 反编译如下：
 * 类私有字段，可以生成一对getter、setter方法
 *
 * public class Counter2 {
 * private int value = 0;
 *
 * public static void main(String[] paramArrayOfString) {
 * Counter2$.MODULE$.main(paramArrayOfString);
 * }
 *
 * private int value() {
 * return this.value;
 * }
 *
 * private void value_$eq(int x$1) {
 *     this.value = x$1;
 * }
 *
 * public void increment() {
 * value_$eq(value() + 1);
 * }
 *
 * public boolean isLess(Counter2 other) {
 * return (value() < other.value());
 * }
 * }
 */

object Counter2 {
  def main(args: Array[String]): Unit = {
    val whn = new Counter2
    whn.increment()
    whn.increment()
    val cjj = new Counter2
    cjj.increment()
    println(whn.isLess(cjj)) // 该字段为该类的私有字段， 方法可以访问该类的所有对象所有私有字段，因此whn的isLess方法可以访问cjj的私有字段value
  }
}

class Counter2 {
  private var value = 0

  def increment() {
    value += 1
  }

  def isLess(other: Counter2): Boolean = {
    value < other.value
  }
}

/**
 * 对象私有字段
 *
 *
 */


/**
 * 反编译如下：
 * 对于类私有的字段， Scala生成私有的getter和setter方法。但对于对象私有的宇段，
 * Scala根本不会生成getter或setter方法。
 *
 * public class Counter3 {
 * private int value = 0;
 *
 * public void increment() {
 *     this.value++;
 * }
 *
 * public void isLess(Counter3 other) {}
 * }
 */
class Counter3 {
  private[this] var value = 0

  def increment() {
    value += 1
  }

  def isLess(other: Counter3) = {
    //    value < other.value         // value 为对象私有字段，其他对象不能访问
  }
}

/**
 * Scala允许你将访问权赋予指定的类。private[类名]修饰符可以定义仅有指定类的方法可以访问给定的字段。
 * private[this]特指当前类的当前对象, 没有getter和setter方法。
 * 这里的类名必须是当前定义的类，或者是包含该类的外部类。在这种情况下，编译器会生成辅助的getter和setter方法，
 * 允许外部类访问该字段。这些类将会是公有的，因为JVM并没有更细粒度的访问控制系统，并且它
 * 们的名称也会随着JVM实现不同而不同。
 */


/**
 * Bean属性
 *
 * Scala对于你定义的字段提供了getter和setter方法。方法名称为age和age_=，不满足JavaBean规范。
 * JavaBean把Java属性定义为一对getFoo/setFoo方法。许多Java工具都依赖这样的命名习惯。
 * 当你将Scala宇段标注为@BeanProperty时，这样的方法会自动生成。
 */

import scala.beans.BeanProperty

/**
 * 反编译如下：
 *   生成了scala的getter/setter方法，同时也生成了符合JavaBean规范的getter、setter方法
 *
 * public class Person2 {
 * private String name;
 *
 * public String name() {
 * return this.name;
 * }
 *
 * public void name_$eq(String x$1) {
 *     this.name = x$1;
 * }
 *
 * public void setName(String x$1) {
 *     this.name = x$1;
 * }
 *
 * public String getName() {
 * return name();
 * }
 * }
 */
class Person2 {
  @BeanProperty var name: String = _
}






