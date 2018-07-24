/**
  * 函数的定义
  */

package com.scala.D2

object FunctionApp {

  def main(args: Array[String]): Unit = {

    // 有入参，有返回值的函数
    def add(x:Int, y:Int):Int = {
      x + y
    }

    // 返回值类型确定，返回值类型可以自动推导出来，可以不写返回值类型
    def add1(x:Int,y:Int) = {
      x + y
    }

    // 没有入参、出参，也没有返回值（返回值类型是Unit）的函数
    def sayHello(): Unit = {
      println("say hello")
    }
    sayHello()
    sayHello    // 当调用的函数没有入参时，可以省略()。（带有默认参数的函数除外）

    // 默认参数
    // 其中spark-default.conf是spark默认的配置文件
    def loadSparkConf(fileName:String = "spark-default.conf"): Unit = {
      println(fileName)
    }
    loadSparkConf()
    loadSparkConf("Spark.conf")

    // 可变参数：参数个数不确定时，适合扩展
    def sum(nums:Int*) = {
      var res = 0
      for (num <- nums) {
        res += num
      }
      res
    }
    println(sum(2,4,6))

    println("-------------------------------")
    // 1.to(10)是一个range类型，我们计算要传参类型为Int。下面的方法可以将Range转换成可变参数，:_*是固定写法
    println(sum(1.to(10) :_*))

    def printFruits(fruits:String*): Unit = {
      for (fruit <- fruits) {
        println(fruit)
      }
    }
    printFruits("apple","orange","banana")
    printFruits(Array("apple","orange","banana"):_*)  // 把Array转成可变参数传进去



    // 命名参数，可以根据名传进去
    def teacher(spark:String, scala:String): Unit = {
      println(spark)
      println(scala)
    }
    teacher("Ruoze", "Jepson")  // 不传时按照顺序写
    teacher(scala="Ruoze",spark="Jepson") // 可以根据名称穿进去


    // 条件表达式
    val x = 100
    val res = if (x > 0) true else false
    println(res)

    // for 循环
    for (i <- 1.to(10) if i % 2 == 0) {
      println(i)
    }

    // 数组遍历:foreach
    Array("aaa","bbb","ccc","ddd").foreach(ele => println(ele))


  }

}
