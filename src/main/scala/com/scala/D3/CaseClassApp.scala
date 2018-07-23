package com.scala.D3

object CaseClassApp {
  def main(args: Array[String]): Unit = {
    println(Dog("Single-Dog").name)
  }

}


/**
  *
  * case class的用途
  * 1）case class是不用new就可以直接使用的
  * 2）模式匹配
  */
case class Dog(name:String)