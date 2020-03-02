package chapter4.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 17:14
 * @ Function:    
 */
object Exercise7 {
  def main(args: Array[String]): Unit = {
    /**
     * 7. 打印出所有Java系统属性的表格， 类似于下面这样：
     * java.runtime.name     | Java (TM ) SERuntimeEnvironment
     * sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
     * java.vm.version       | 17.0-blG
     * java.vm.vendor        | SunMicrosystemsinc.
     * java.vendor.url       | http://java.sun.com/
     * path.separator        | :
     * java.vm.name          | JavaHotSpot(TM)ServerVM
     * 你需要找到最长的键，这样才能正确地打印出这张表格。
     */

    import scala.collection.JavaConversions.propertiesAsScalaMap
    val propMap: scala.collection.mutable.Map[String, String] = System.getProperties
    val maxPropLen = propMap.map(_._1.length).max
//    println(maxPropLen)
//    propMap.foreach(println)
    for ((k, v) <- propMap) {
      val keyLen = k.length
      println(k + " " * (maxPropLen - keyLen) + " | " + v)
    }
  }
}
