package com.scala.D2

/**
  * 类 & 属性
  */

object SimpleClassApp {

  def main(args: Array[String]): Unit = {

    // 类的调用
    // new 一个类出来
    val people = new People
    people.name = "scala"

//    println(people.gender)   // gender是私有属性，不能直接调用
    people.printInfo()  // 但是gender在这里是被class本身调用，可以合法使用

    val a = people.eat()
    println(a)
  }

}


// 定义一个类
class People {

  // 定义属性
//  var name:String = ""
  var name:String = _   // name这里也可以直接使用占位符占位
  val age = 10
  private[this] val gender = "M"   // gender是类People的一个私有属性，在外面是不能直接被调用的

  def printInfo(): Unit = {
    println(gender)
  }

  // 定义方法
  def eat() = {
    name + " eat banana."
  }

}