package com.scala.D3

object ArrayApp {

  def main(args: Array[String]): Unit = {

    println("=====================Array====================")

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


    println("==================ArrayBuffer==================")

    // 工作中一般使用的Array都是变长的ArrayBuffer

    import scala.collection.mutable.ArrayBuffer
    //定义一个变长的数组，长度为空
    val c = ArrayBuffer[Int]()

    // 向变长数组里面添加一个元素
    c += 1
    println(c)

    // 添加多个元素
    c += (2,3,4)
    println(c)

    // append方法也可以一次添加多个元素
    c.append(9,9,8)
    println(c)

    // 添加定长数组。变长+定长使用++=
    c ++= Array(7,8,9,10,11,12,13,14,15,16)
    println(c)

    // 上面的方法都是向右加
    // 下面的方法插入到指定的地方(从第0个位置开始，添加一个0)
    c.insert(0,0)
    println(c)

    println("*****************")
    // 从集合中减去一个元素，当该元素有多个时，减去左边开始第一个
    c -= 9
    println(c)


    // 删除指定位置的一个值(下标从0开始）
    c.remove(1)
    println(c)

    // 删除指定位置的多个值（从0开始删掉3个值）
    c.remove(0,3)
    println(c)

    // 删除最后的n个元素
    c.trimEnd(2)
    println(c)

    // 运算方法
    println(c.max)
    println(c.min)
    println(c.sum)
    println(c.length)

    println(c.mkString)
    println(c.mkString(","))

    // 变长数组转成定长数组
    // ArrayBuffer转换成定长的Array
    val c1 = c.toArray
    println(c1)


    println("==================数组遍历==================")

    for (i <- 0 until(c.length)) {
      println(i)
    }

    // 增强for循环
    for (ele <- c) {
      println(ele)
    }
  }

}
