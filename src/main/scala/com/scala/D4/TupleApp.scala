package com.scala.D4

object TupleApp extends App {

  // 定义一个tuple
  val a = (1,2,3,4,5)
  println(a._1 + " " + a._2)

  val ipPort = "192.168.1.7:3306"
  val ip = ipPort.split(":")(0)
  val port = ipPort.split(":")(1)
  println(ip)
  println(port)



}
