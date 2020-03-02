package chapter4.test

import java.util

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.test
 * @ author:   whn
 * @ date:     2020-3-2 14:04
 * @ Function:
 */
object Overview {
  def main(args: Array[String]): Unit = {
    /**
     * 第4章 映射和元组
     */

    /**
     * 1. 构造映射,映射通常只是用来查询数据。
     */

    val map = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // 不可变映射
    val map2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8)) // 映射的另一种创建方式， 通常->比圆括号更易读一些。
    val bufferMap = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // 可变映射
    val bufferNewMap = scala.collection.mutable.Map[String, Int]() // 空的可变映射
    val aliceScore = if (map.contains("Alice")) map("Alice") else 0 // contains用于检查map中键是否存在
    val aliceScore2 = map.getOrElse("Alice", 0) // 上面功能的简单实现，查询是否有该键，有就取出来，没有给个默认的值。

    /**
     * 2. 遍历映射
     */

    for ((k, v) <- map) { // 遍历键值对
      println(s"key: $k  value: $v")
    }
    for (k <- map.keySet) { // 遍历键
      println(k)
    }
    for (v <- map.values) { // 遍历值
      println(v)
    }

    /**
     * 3. 已排序映射
     *
     * 映射有两种常见的实现策略：哈希表和平衡树。哈希表使用键的晗希码来划定位
     * 置，因此遍历会以一种不可预期的顺序交出元素。默认而言， Scala给你的是基于哈
     * 希表的映射，因为它通常更高效。如果需要按照顺序依次访问映射中的键，可以使用
     * SortedMap。
     */

    val linkedMap = scala.collection.mutable.LinkedHashMap("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // 按插入顺序访问Map
    val sortedMap = scala.collection.immutable.SortedMap("Alice" -> 10, "Cindy" -> 8, "Bob" -> 3) // 按顺序访问Map
    //    sortedMap.foreach(println)

    /**
     * 4. 与Java互操作
     */

    // (1) 场景1: 由Java方法得到了一个Java映射，我们想把Java映射转换为Scala映射以便能够使用scala的更多API
    // 我们可以通过指定scala映射类型来触发隐式转换。
    import scala.collection.JavaConversions.mapAsScalaMap
    val scores: scala.collection.mutable.Map[String, Int] = new util.TreeMap[String, Int]()
    // (2) 场景2： java.util.Properties => scala映射
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.mutable.Map[String, String] = System.getProperties

    // (3) 场景3: 我们需要将一个Scala映射转变为Java映射，传入到需要调用的Java方法中。
    import scala.collection.JavaConversions.mapAsJavaMap
    import scala.collection.JavaConversions.mapAsJavaMap
    import java.awt.font.TextAttribute._ // 引入下面的映射会用到的键
    val attrs = Map(FAMILY -> "Serif", SIZE -> 12) // Scala映射, 传入下面的Java方法时通过隐式转换转变成Java映射
    val font = new java.awt.Font(attrs) // 该方法需要调用一个Java映射


    /**
     * 5. 映射是键／值对偶的集合。对偶是元组的最简单形态——元组是不同类型的值的聚集。
     * 元组的值是通过将单个的值包含在圆括号中构成的，可以包含不同类型的值。当返回值为多个不同类型的，建议使用元组，元组最多支持22个元素。
     */

    val tuple: (Int, Double, String) = (1, 3.14, "Fred")
    println(tuple._1) // 通过_1， _2 ......访问， 从1开始

    val res1: (String, String) = "New York".partition(_.isUpper)
    println(res1) // (NY,ew ork), 返回一个元组，一个是满足条件的返回值，一个是不满足条件的返回值

    /**
     * 6. 元组的拉链操作
     */

    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts) // 返回对偶组成的数组
    //    pairs.foreach(println) // (<,2) (-,10) (>,2)
    for ((k, v) <- pairs) {
      print(k * v)
    }
    println()

    //用toMap 方法可以将对偶的集合转换成映射。
    //如果你有一个键的集合，以及一个与之平行对应的值的集合，就可以用拉链操作将它们组合成一个映射.
    val res2: Map[String, Int] = symbols.zip(counts).toMap



  }

}
