package com.scala.D4

object StringApp  extends App {

  // 定义单行string
  val s = "Hello Scala"
  println(s)

  // 多行：按住shift，敲三下双引号""""""
  val s1 =
    """
      |hello world
      |hello scala
      |hello spark
    """.stripMargin
  println(s1)

  // 字符串插值：String Interpolation
  val s2 = "hello scala"
  println(s"$s2")




}
