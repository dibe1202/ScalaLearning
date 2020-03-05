package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 13:56
 * @ Function:    
 */
object Exercise1 {
  def main(args: Array[String]): Unit = {
    /**
     * 1. 改进5.1节的counter类，让它不要在Int.MaxValue时变成负数。
     */

    val count1 = new Counter
    println(count1.current)
    count1.increment()
    println(count1.current)
    count1.increment()
    println(count1.current)
  }
}

class Counter {
  private var value = Int.MaxValue

  def increment() {
    if (value < Int.MaxValue) value += 1 else value
  }

  def current: Int = value
}
