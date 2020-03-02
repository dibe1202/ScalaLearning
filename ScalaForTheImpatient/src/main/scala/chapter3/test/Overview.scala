package chapter3.test

import scala.collection.mutable.ArrayBuffer

/**
 * @ project:  Scalalearning
 * @ package:  chapter3.test
 * @ author:   whn
 * @ date:     2020-2-25 9:38
 * @ Function: 第三章 数组相关操作
 */
object Overview {
  def main(args: Array[String]): Unit = {

    /**
     * 1. 固定长度数组Array
     *
     * Inside the JVM, a Scala Array is implemented as a Java array. The arrays in the
     * preceding example have the type java.lang.String[] inside the JVM. An array of
     * Int, Double, or another equivalent of the Java primitive types is a primitive type
     *    array. For example, Array(2,3,5,7,11) is an int[] in the JVM.
     */

    val nums = new Array[Int](10)
    // An array of ten integers, all initialized with zero
    println(nums.mkString(" "))

    val a = new Array[String](10)
    // A string array with ten elements, all initialized with null
    println(a.mkString(" "))

    val s = Array("Hello", "World")
    // An Array[String] of length 2—the type is inferred
    // Note: No new when you supply initial values
    println(s.mkString(" "))
    s(0) = "Goodbye"
    // Array("Goodbye", "World")
    // Use () instead of [] to access elements
    println(s(0))


    /**
     * 2. 可变长数组, ArrayBuffer
     *
     * Java has ArrayList and C++ has vector for arrays that grow and shrink on demand.
     * The equivalent in Scala is the ArrayBuffer.
     *
     * import scala.collection.mutable.ArrayBuffer
     */

    //TODO (1). 在数组末尾操作
    //Adding or removing elements at the end of an array buffer is an efficient
    //(“amortized constant time”) operation. // 在数组的末尾添加或删除元素是一个高效操作(平摊常量时间)。

    val b = ArrayBuffer[Int]()
    // Or new ArrayBuffer[Int]
    // An empty array buffer, ready to hold integers

    b += 1
    // ArrayBuffer(1)
    // Add an element at the end with +=

    b += (1, 2, 3, 5)
    // ArrayBuffer(1, 1, 2, 3, 5)
    // Add multiple elements at the end by enclosing them in parentheses

    b ++= Array(8, 13, 21)
    // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)
    // You can append any collection with the ++= operator

    b.trimEnd(5)
    // ArrayBuffer(1, 1, 2)
    // Removes the last five elements


    //TODO (2). 在数组任意位置操作
    //You can also insert and remove elements at an arbitrary location, but those operations
    //are not as efficient—all elements after that location must be shifted. For example:

    b.insert(2, 6)
    // ArrayBuffer(1, 1, 6, 2)
    // Insert before index 2

    b.insert(2, 7, 8, 9)
    // ArrayBuffer(1, 1, 7, 8, 9, 6, 2)
    // You can insert as many elements as you like

    b.remove(2)
    // ArrayBuffer(1, 1, 8, 9, 6, 2)

    b.remove(2, 3)
    // ArrayBuffer(1, 1, 2)
    // The second parameter tells how many elements to remove

    //TODO (3). Array和ArrayBuffer的转换
    //Sometimes, you want to build up an Array, but you don’t yet know how many
    //elements you will need. In that case, first make an array buffer, then call
    //b.toArray. Conversely, call a.toBuffer to convert the array a to an array buffer.

    a.toBuffer // scala.collection.mutable.ArrayBuffer
    b.toArray // Array

    //TODO (4). 遍历数组
    //In Java and C++, there are several syntactical differences between arrays and
    //array lists/vectors. Scala is much more uniform. Most of the time, you can use
    //the same code for both.

    for (i <- b.indices) print(b(i) + " ") // 遍历数组中的每一个元素，步长默认1
    println()
    for (i <- b.indices by 2) print(b(i) + " ") // 遍历数组中的每一个元素，步长为2
    println()
    for (i <- b.indices.reverse) print(i + " ") // 逆序遍历数组中的每一个元素
    println()
    for (elem <- b) print(elem + " ") // 如果不需要index，则可以这样遍历，类似java中的增强循环
    println()

    //TODO (5). 利用for推导式生成新数组
    //Such transformations don’t modify the original array but yield a new one.
    //And the type of the new one is the same as the original collection.
    //That means  Array -> Array       ArrayBuffer -> ArrayBuffer
    val arr = Array(2, 3, 5, 7, 11)
    val res1 = for (elem <- arr) yield 2 * elem
    // result is Array(4, 6, 10, 14, 22)
    println(res1.mkString(","))
    val res2 = for (elem <- arr if elem % 2 == 0) yield 2 * elem // 帶if守卫
    println(res2.mkString(","))

    //TODO (6). 数组的一些常用方法

    Array(1, 7, 2, 9).sum
    // 19
    // Works for ArrayBuffer too

    ArrayBuffer("Mary", "had", "a", "little", "lamb").max
    // "little"  首字母相同，按第二个字母排序，依次类推

    val arrB = ArrayBuffer(1, 7, 2, 9)
    val arrBSorted = arrB.sorted
    // arrB is unchanged; bSorted is ArrayBuffer(1, 2, 7, 9)

    val bDescending = b.sortWith(_ > _) // ArrayBuffer(9, 7, 2, 1)
    println(arrB.mkString(" and ")) // 1 and 7 and 2 and 9
    println(arrB.mkString("<", "-", ">")) // <1-7-2-9>

    //TODO (7). 多维数组

    val matrix = Array.ofDim[Double](3, 4) // Three rows, four columns
    matrix(0)(0) = 42

    val triangle = new Array[Array[Int]] (10)  // 不规则数组
    for (i <- triangle.indices)
    triangle (i) = new Array[Int] (i + 1)

    //TODO (8). 与Java互操作



  }
}
