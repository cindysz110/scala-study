package com.scala.D3

/**
  * 计数器
  * 1) object 修饰的类不需要new就能直接使用
  * 2）类似于静态类
  */


object Timer {

  var count = 0

  def currentCount():Long = {
    count += 1
    count
  }

  def main(args: Array[String]): Unit = {

    // object修饰的类不需要new就能直接使用
    println(Timer.currentCount())
    println(Timer.currentCount())
    println(Timer.currentCount())
  }
}
