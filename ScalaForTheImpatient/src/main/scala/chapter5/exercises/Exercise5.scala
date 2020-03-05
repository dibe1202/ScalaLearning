package chapter5.exercises

import scala.beans.BeanProperty


/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 14:48
 * @ Function:    
 */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    /**
     * 5. 创建一个Student类，加入可读写的JavaBeans属性name(类型为String)和id(类型为Long)。
     * 有哪些方法被生成？（用javap查看。）你可以在Scala中调用JavaBeans版的getter和setter方法吗？应该这样做吗？
     *
     * A: 使用@BeanProperty增加兼容JavaBean的getter和setter方法。
     */
  }
}

/**
 * 反编译如下：
 * public class Student {
 * private String name = "";
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
 *
 * private long id = 0L;
 *
 * public long id() {
 * return this.id;
 * }
 *
 * public void id_$eq(long x$1) {
 *     this.id = x$1;
 * }
 *
 * public void setId(long x$1) {
 *     this.id = x$1;
 * }
 *
 * public long getId() {
 * return id();
 * }
 * }
 */
class Student {
  @BeanProperty var name:String = ""
  @BeanProperty var id:Long = 0
}
