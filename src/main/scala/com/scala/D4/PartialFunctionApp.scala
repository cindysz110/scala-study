package com.scala.D4

object PartialFunctionApp extends App {

  // 模式匹配函数
  def sayChineseName(name:String) = name match {
    case "apple" => println("苹果")
    case "banana" => println("香蕉")
    case "orange" => println("橙子")
    case _ => println("Unknown fruit.")
  }
  sayChineseName("apple")

  // 偏函数
  /**
    *
    * PartialFunction[A,B]: A代表入参类型，B代表出参类型
    */
  def sayChineseName2:PartialFunction[String, String] = {
    case "apple" => "苹果"
    case "banana" => "香蕉"
    case "orange" => "橙子"
    case _ => "Unknown fruit."
  }
  println(sayChineseName2("apple"))
}
