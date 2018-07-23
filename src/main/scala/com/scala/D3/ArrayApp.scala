package com.scala.D3

object ArrayApp {

  def main(args: Array[String]): Unit = {

    // 数组定义
    val a = new Array[String](5)

    // 数组定义并赋值
    val a1 = Array("aaa","bbb","ccc") // 这种定义方法必然是调用了object中的apply方法，在apply中new了一个class

    // 数组取值
    // length
    println(a1.length)

    // 下标从0开始
    println(a1(0))

    // 修改数组的值
    a1(2) = "ddd"
    println(a1(2))

    // 数值型的数组支持各种计算的方法
    val a2 = Array(1,2,3,4,5,6,7,8,9)
    println(a2.max)
    println(a2.min)
    println(a2.sum)


    // 数组里面所有的元组拼接成一个长字符串
    println(a2.mkString)
    // 数组里面所有的元组拼接成一个长字符串，用，作为分隔符
    println(a2.mkString(","))
    /**
      * 第一个参数：拼接字符串左边的值
      * 第二个参数：分隔符
      * 第三个参数：拼接字符串右边的值
      */
    // 数组里面所有的元组拼接成一个长字符串，用，作为分隔符。并且在前后加上[]
    println(a2.mkString("[",",","]"))


    // 工作中一般使用的Array都是变长的ArrayBuffer

  }

}
