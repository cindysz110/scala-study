package com.scala.D4

import java.io.FileNotFoundException

import scala.io.{Codec, Source}

object ExceptionApp extends App {

  try {
//    val i = 1/0
    val file = Source.fromFile("test1.txt")(Codec.UTF8)
  } catch {
    // 模式匹配，没有顺序，完全模式匹配
    case e: ArithmeticException => throw new RuntimeException("除数不能为0")   // 抛出异常，程序停止
    case e: FileNotFoundException => println("文件找不到")                     // 只打印异常，程序不停止
    case e: Exception => println(e.getMessage)
    case _ => println(" : ")                                                  // 剩下的情况

  } finally {
    println("finally")
  }
}
