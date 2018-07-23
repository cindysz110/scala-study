package com.scala.D3

object ListApp {

  def main(args: Array[String]): Unit = {

    println("=====================List====================")

    // 创建一个空List
    val l = Nil
    val l1 = List()
    println(l)
    println(l1)


    // 创建一个List
    val l2 = List(1,2,3,4,5)
    println(l2)

    // 返回List的第一个元素
    println(l2.head)

    // 返回的是去掉head之外的List
    println(l2.tail)

    // 头 :: 尾 = 头 + 尾
    val l3 = 1 :: Nil
    println(l3)

    // 2开头，集合l3结尾
    val l4 = 2 :: l3
    println(l4)

    // 1，2，3
    val l5 = 1 :: 2 :: 3 :: Nil
    println(l5)

    //
    println(l5.length)

    println("=====================ListBuffer====================")

    import scala.collection.mutable.ListBuffer
    val l6 = ListBuffer[Int]()

    // 向List添加元素
    l6 += 2
    l6 += (3,4,5,6,7,8,9)
    println(l6)

    // 从List中减去元素
    l6 -= 3
    println(l6)

    // 减去一个List当中没有的元素1，不会报错
    l6 -= (1,4)
    println(l6)

    // 可变List +/- List用++=/--=
    l6 ++= l5
    println(l6)

    l6 --= List(1,2,3)
    println(l6)

    // ListBuffer转换成定长的List
    println(l6.toList)

    println("----")

    // head
    println(l5.head)
    println(l5.tail)
    println(l5.tail.tail)

  }

}
