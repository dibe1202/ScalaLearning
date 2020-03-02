package chapter4.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter4.exercises
 * @ author:   whn
 * @ date:     2020-3-2 17:34
 * @ Function:    
 */
object Exercise10 {
  def main(args: Array[String]): Unit = {
    /**
     * 10. 当你将两个字符串拉链在一起时，比如"Hello".zip("World")，会是什么结果？想出一个讲得通的用例。
     *
     * A: String可以看成是字符数组，也就是可迭代的，那么zip就是针对每个字符进行对偶组合。
     */
    val res = "Hello".zip("World")
//    (H,W)
//    (e,o)
//    (l,r)
//    (l,l)
//    (o,d)
    res.foreach(println)


  }

}
