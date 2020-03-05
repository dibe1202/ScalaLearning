package chapter5.exercises

/**
 * @ project:  Scalalearning
 * @ package:  chapter5.exercises
 * @ author:   whn
 * @ date:     2020-3-5 14:19
 * @ Function:    
 */
object Exercise2 {
  def main(args: Array[String]): Unit = {
    /**
     * 2. 编写一个BankAccount类， 加入deposit和withdraw方法，以及一个只读的balance属性。
     *
     */

    val whn = new BankAccount
    whn.deposit(2000)
    whn.withdraw(1000)
    println(whn.current)
  }
}

class BankAccount {
  private var balance = 0.0 // 私有属性

  def deposit(money: Double): Unit = {
    this.balance += money
  }

  def withdraw(money: Double): Unit = {
    this.balance -= money
  }
  def current: Double = balance // 定义一个方法
}
