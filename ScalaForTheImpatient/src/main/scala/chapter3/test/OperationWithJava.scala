package chapter3.test

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.test
 * @ author:   whn
 * @ date:     2020-2-25 16:06
 * @ Function:    
 */
object OperationWithJava {
  def main(args: Array[String]): Unit = {
    /**
     * 1. 在Java中，给定类型的数组会被自动转换成超类型的数组。例如， Java的String[]数组可以
     * 被传入一个预期Java的Object[]数组的方法。Scala并不允许这样的自动转换，因为这
     * 样的转换不安全.
     */

    val arr = Array("Mary", "a", "had", "lamb", "little")
    //    java.util.Arrays.binarySearch(arr,"beef") //这样行不通,因为Scala不会将Array[String］转换为Array[Object］
    val res1 = java.util.Arrays.binarySearch(arr.asInstanceOf[Array[Object]], "had") // 做强制转换
    println(res1)

    /**
     * 2. 如果你调用接受或返回java.util.List的Java方法,可以引人scala.collection.JavaConversation
     * 里的隐式转换方法。这样你就可以在代码中使用Scala缓冲，在调用Java方法时这些对象会被自动包装成Java列表。
     * 反过来讲，当Java方法返回java.util.List时，我们可以让它自动转换成一个Buffer
     */

    import scala.collection.JavaConversions.bufferAsJavaList
    import scala.collection.mutable.ArrayBuffer
    val command = ArrayBuffer("ls","-al", "/home/cay")
    val pb = new ProcessBuilder(command)  // 该java方法需要传递一个List<String>， 通过隐式转换，会将scala的ArrayBuffer转换成该java对象

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer
    val cmd:Buffer[String] = pb.command()  // java方法返回的List<String>类型，通过隐式转换转换为scala的Buffer[String]
                                           // 这里只能返回Buffer[String], 包装对象仅能保证是一个buffer。


  }

}
