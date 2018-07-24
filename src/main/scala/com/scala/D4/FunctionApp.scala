package com.scala.D4

object FunctionApp {

  def main(args: Array[String]): Unit = {

    val l = List(1,2,3,4,5,6,7,8,9)

    println("=====================map========================")
    // map：对集合中的每一个元素都做一个操作
    println(l.map((x:Int) => x * 2))

    // 明确知道这是一个全部都是Int类型元素的List，可以把x后面的Int类型省略
    println(l.map((x) => x * 2))

    // 因为map里面只有一个入参x，所以入参外层的括号可以省略
    println(l.map(x => x * 2))

    // 终极写法: 占位符
    println(l.map(_ * 2))

    println("=====================foreach====================")
    l.map(_*2).foreach(println)

    println("=====================filter=====================")
    println(l.map(_*2).filter(_ > 10))

    println("=====================take=======================")
    // 取集合里面的元素
    println(l.take(3))


    println("=====================reduce=======================")
    // reduce函数：两两相邻的元素做某一个操作
    println(l.reduce(_+_))        // 1+2+3+4+5+6+7+8+9
    println(l.reduce(_-_))        // 1-2-3-4-5-6-7-8-9

    println("=====================reduceLeft=======================")
    println(l.reduceLeft(_+_))    // 1+2+3+4+5+6+7+8+9
    println(l.reduceLeft((_-_)))  // 1-2-3-4-5-6-7-8-9

    println("=====================reduceRight=======================")
    // 8+9=17
    // 7+17=24
    // 6+24=30
    // 5+30=35
    // 4+35=39
    // 3+39=42
    // 2+42=44
    // 1+44=45
    println(l.reduceRight(_+_))   // 8+9+7+6+5+4+3+2+1
    // 拆解打印执行过程
    l.reduceRight((a,b) => {
      println(a + " " + b)
      a + b
    })


    // 8-9=-1
    // 7-(-1)=8
    // 6-8=-2
    // 5-(-2)=7
    // 4-7=-3
    // 3-(-3)=6
    // 2-6=-4
    // 1-(-4)=5
    println(l.reduceRight(_-_))   // (8-9)
    // 拆解打印执行过程
    l.reduceRight((a,b) => {
      println(a + " " + b)
      a - b
    })

    println("=====================fold=======================")
    println(l.fold(0)(_+_))
    println(l.fold(10)(_+_))

    println("=====================foldLeft=======================")

    /**
      * 第一个参数是一个初始值，最终的结果加上这个值
      */
    println(l.foldLeft(0)(_+_))
    println(l.foldLeft(10)(_+_))
    println(l.foldLeft(0)(_-_))
    println(l.foldLeft(10)(_-_))

    println("=====================foldRight=======================")
    println(l.foldRight(0)(_+_))
    println(l.foldRight(10)(_+_))
    println(l.foldRight(0)(_-_))
    println(l.foldRight(10)(_-_))

    println("=================max/min/sum/length/count============")
    println(l.max)
    println(l.min)
    println(l.sum)
    println(l.length)
    // 集合中大于3的元素的个数
    println(l.count(_>3))

    println("=====================zip=======================")
    // 组合成tuple
    val a = List(1,2,3,4)
    val b = List("a","b","c","d")
    println(a.zip(b))
    println(b.zip(a))

    // 左边和右边的数量能匹配上的才能输出，类比inner join
    val c = List("a","b","c","d","e")
    println(a.zip(c))
    println(c.zip(a))

    println("=====================flatten=======================")
    // 打扁
    val f = List(List(1,2),List(3,4),List(5,6))
//    f.foreach(println)

    // 压扁
    println(f.flatten)
    // flatMap里面的每一个元素是一个int
    println(f.flatMap(_.map(_*2)))

    // n -> (n,1)
    println(f.flatMap(_.map((_,1))))

    // 按照key分组
    println(f.flatMap(_.map((_,1))).groupBy(_._1))

    // => (key,length)
    println(f.flatMap(_.map((_,1))).groupBy(_._1).map(t => (t._1,t._2.length)))


  }

}
