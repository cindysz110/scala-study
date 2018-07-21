package com.scala

object ScalaFunctionApp {
  def main(args: Array[String]): Unit = {
    def add(x:Int, y:Int):Int = {   // 其中，返回值类型Int和它前面的冒号可以省略
      x + y
    }
    val a = add(3,4)
    println(a)



    def sayHello = {
      println("Hi~")
    }
    sayHello    // 当调用的函数没有入参时，可以省略括号


    // 把一长串的条件判断语句赋给一个变量也可以
    val x = 100
    val b = if (x > 0) true else false
    println(b)

    val c = 1 to 10
    val c1 = 1.to(10)   // 这种写法与上面等价
    println(c)    // Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(c1)

    val d = 1 until 10
    val d1 = 1.until(10)    // 这种写法与上面等价
    println(d)    // Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(d1)

    val e = Range(1,10,1) // Range(起始，结束，步长）,Range 等价until
    println(e)    // Range(1, 2, 3, 4, 5, 6, 7, 8, 9)


    // for 循环
    for(i <- 0 until 10 if i%2==0) {
      println(i)
    }

    // 数组, foreach 遍历
    val f = Array("a","b","c","d","e").foreach(i => println(i))


    // 默认参数
    def loadSparkConf(fileName:String = "spark-default.conf"): Unit = {
      println(fileName)
    }

    loadSparkConf()
    loadSparkConf("spark-abc.conf")

    // 命名参数： 可以根据参数的名字传进去。只做了解即可
    def teacher(spark: String, linux: String): Unit = {
      println(spark)
      println(linux)
    }
    teacher("aaaa","bbbb")
    teacher(linux = "aaaa", spark = "bbbb")

    // 变成参数：可变参数
    def sum(a: Int, b: Int) = {
      a + b
    }
    println(sum(2,4))

    // 在上面的基础上增加入参的个数，增加可扩展性
    def sum1(nums:Int*) = {
      var result = 0
      for(num <- nums) {  // 类似java中的增强的for循环
        result += num
      }
      result
    }
    println(sum1(2,4,68))
    println(sum1(1.to(10) :_*))   // 1.to(10)是一个range，后面的方法将其转换成数字

    def printFruits(fruits: String*): Unit = {
      for (fruit <- fruits) {
        println(fruit)
      }
    }
    printFruits("apple", "orange")
    printFruits(Array("apple", "orange") :_*)   // 把数组转换成可变参数
  }
}
