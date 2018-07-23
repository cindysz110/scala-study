package com.scala.D3

// 这里的App是一个trait，有App接口之后这个object不需要main方法
object MapApp extends App {

  println("=====================不可变的Map====================")

  // 定义一个Map
  val a = Map("k1" -> "v1", "k2" -> "v2" )
  println(a)

  // 取Map中一个key的value
  println(a("k1"))

  // 不可变Map里面的值不能被改变
  // a("k1") = "v3"

  println("=====================HashMap可变====================")

  import scala.collection.mutable.HashMap

  // 定义一个HashMap
  val c = HashMap[String, Int]()

  // 向HashMap添加数据
  c("k1") = 1
  c("k2") = 2
  c += ("k3" -> 3)
  c += ("k4" -> 4, "k5" -> 5, "k6" -> 6)
  println(c)

  c += ("k3" -> 3)

  // 可以修改
  c("k1") = 3
  println(c)

  // 不能取不在Map里面的key，报错
  // println(c("k3"))
  // 工作中正确的做法是用get方法取value对应的值
  println(c.get("k1"))
  println(c.getOrElse("k1", 9999))




}
