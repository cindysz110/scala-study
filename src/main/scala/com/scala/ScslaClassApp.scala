package com.scala

object ScslaClassApp {

  def main(args: Array[String]): Unit = {
    val people = new People
    people.name = "scala"
    people.age = 20
    println(people.name + " : " + people.age)

    // 可以这样用
    people.printInfo()
    // 不能这样用  // println(people.name + " : " + people.age + " ：" + people.gender)

  }

}


// 定义一个类
class People {

  // 定义属性
  var name: String = ""
  var age = 10 // var age:Int = 10

  private[this] val gender = "M"   // 私有属性，只能在函数内部用。参照Spark源码，入口类SparkContext

  // 定义方法
  def eat(): String = {
    name + " eat ..."
  }

  def printInfo(): Unit = {
    println("gender: " + gender)
  }

}