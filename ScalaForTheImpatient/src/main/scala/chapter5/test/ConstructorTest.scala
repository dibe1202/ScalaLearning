package chapter5.test

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.test
 * @ author:   whn
 * @ date:     2020-3-3 13:53
 * @ Function:    
 */
object ConstructorTest {
  def main(args: Array[String]): Unit = {

  }
}

/**
 * 5.6 辅助构造器
 *
 * 和Java或C++一样， Scala也可以有任意多的构造器。不过Scala类有一个构造器比
 * 其他所有构造器都更为重要，它就是主构造器。除主构造器外，类还可以有任意多的
 * 辅助构造器。我们先讨论辅助构造器:
 *   a. 辅助构造器的名称为this。(在Java或C++中，构造器的名称和类名相同一一当你修改类名时就不那么方便了。）
 *   b. 每一个辅助构造器都必须以一个对先前已定义的其他辅助构造器或主构造器的调用开始。
 *
 */

object Person3 {
  def main(args: Array[String]): Unit = {
    /**
     * 一个类如果没有显式定义主构造器， 则自动拥有一个无参的主构造器。
     */

    val p1 = new Person3() // 主构造器
    val p2 = new Person3("whn") // 第一个辅助构造器
    val p3 = new Person3("cjj", 30) // 第二个辅助构造器

  }
}

class Person3 {
  private var name = ""
  private var age = 0

  def this(name: String) { // 一个辅助构造器
    this() // 调用主构造器
    this.name = name
  }

  def this(name: String, age: Int) { // 第二个辅助构造器
    this(name)
    this.age = age
  }
}

/**
 * 5.7 主构造器
 *
 * 在Scala中，每个类都有主构造器。主构造器并不以this方法定义，而是与类定义交织在一起。
 *    a. 主构造器的参数直接放置在类名之后。
 *    b. 主构造器会执行类定义中的所有语句。
 *    c. 主构造器的参数如果不带val或var，这样的参数如何处理取决于它们在类中如何被使用，
 *    如果至少被一个方法所使用，它将被升格为字段，并且该字段是对象私有字段；
 *    否则该参数将不被保存为字段，它仅仅是一个可以被主构造器中的代码访问的普通参数.
 */


/**
 * @param name
 * @param age
 *     反编译如下：
 *     参数name、age定义为该类的字段，并生成对应的getter/setter方法
 *     public class Person4 {
 *     private final String name;    // val 不可变， 只生成getter方法
 *
 *     private int age;
 *
 *     public String name() {
 *     return this.name;
 *     }
 *
 *     public int age() {
 *     return this.age;
 *     }
 *
 *     public void age_$eq(int x$1) {
 *     this.age = x$1;
 *     }
 *
 *     public Person4(String name, int age) {}   // 主构造函数
 *     }
 */
class Person4(val name: String, var age: Int) { // 半行代码，完成了上面Java 10行代码的功能。
  println("Just constructed another person") // println语句是主构造器的一部分。每当有对象被构造出来时就被执行。当你需要在构造过程中配置某个字段时，这个特性特别有用

  def description(): Unit = println(s"$name is $age years old.")
}

object Person4 {
  def main(args: Array[String]): Unit = {
    val wyc = new Person4("whc", 2)
    wyc.description()
  }
}

/**
 * 当你把主构造器的参数看作类参数时，不带val或var的参数就变得易于理解了。这样的参数的作用域涵盖了整个类。
 * 因此，你可以在方法中使用它们。而一旦你这样做了，编译器就自动帮你将它保存为字段。
 */





