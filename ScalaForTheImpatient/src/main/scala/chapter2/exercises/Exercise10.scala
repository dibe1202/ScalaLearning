package chapter2.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter2.exercises
 * @ author:   whn
 * @ date:     2020-2-24 17:34
 * @ Function:    
 */
object Exercise10 {
  def main(args: Array[String]): Unit = {
    /**
     * 10. 编写函数计算x的n次方，其中n是整数，使用如下的递归定义：
     * x的n次方 = y * y ，如果n是正偶数的话，这里的y = x的n/2次方。
     * x的n次方 = x * x的n-1次方， 如果n是正奇数的话
     * x的0次方 = 1
     * x的n次方 = 1 / x的-n次方, 如果n是负数的话。
     * 不得使用return语句。
     *
     */
    println(recurFun(2, 4))
  }

  def recurFun(x: Long, n: Long): Long = {
    if (n == 0) 1
    else if (n % 2 == 0) { // n为正偶数
      recurFun(x, n / 2) * recurFun(x, n / 2)
    }
    else if (n % 2 != 0) { // n为正奇数
      x * recurFun(x, n - 1)
    }
    else { // n < 0)
      1 / recurFun(x, -n)
    }
  }

}
