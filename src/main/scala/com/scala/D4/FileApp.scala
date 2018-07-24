package com.scala.D4

import scala.io.{Codec, Source}
import scala.xml.XML

object FileApp extends App {

  /**
    *
    * currying 颗粒化
    * 将原来函数的2个入参拆开
    * 这种做法在Spark SQL UDF里面常用
    */
  def sum(a:Int, b:Int) = a + b
  def sum2(a:Int)(b:Int) = a + b
  println(sum(2,4))
  println(sum2(2)(4))


  println("=====================read fromFile========================")
  // val file = Source.fromFile("E:\\Language\\scala\\ScalaProjects\\scala-study\\test.txt")(Codec.UTF8)
  // 不指定文件的绝对路径时，默认的路径是maven工程的家目录
  // 读取时可以指定文件的编码方式
  val file = Source.fromFile("test.txt")(Codec.UTF8)
  def readLine() = {
    for (line <- file.getLines()) {
      println(line)
    }
  }
  readLine()

  println("=====================read fromURL========================")
  // 读接口
  def readApi(): Unit = {
    val content = Source.fromURL("http://www.baidu.com")
    for (line <- content.getLines()) {
      println(line)
    }
  }
  readApi()

//  println("=====================read fromXML========================")
//  // 了解即可
//  def readXML(): Unit = {
//    XML.load("")
//  }


}
