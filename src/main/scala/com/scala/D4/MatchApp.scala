package com.scala.D4

import scala.util.Random

object MatchApp extends App {

  val fruits = Array("apple", "banana", "orange")

  val fruit = fruits(Random.nextInt(fruits.length))
  fruit match {
    case "apple" => println("苹果")
    case "banana" => println("香蕉")
    case "orange" => println("橙子")
    case _ => println("Unknown fruit.")
  }

  println("==================================================")

  def greeting(array:Array[String]): Unit = {
    array match {
      case Array("scala") => println("hello scala")
      case Array(x, y) => println(x + " " + y)
      case Array("scala", _*) => println("Hi scala and there")          // _* 代表可变参数
      case Array(_*) => println("Hi there")
      case _ => println("Hi there 1")                                   // 与上面的等价
    }
  }

  greeting(Array("scala"))
  greeting(Array("scala","python"))
  greeting(Array("scala","python","java"))
  greeting(Array("python","java","scala"))

}
