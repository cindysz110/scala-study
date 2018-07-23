package com.scala.D3

/** class Timer与object Timer同名，互为伴生。object是class的伴生对象，class是object的伴生类
  * 一般互为伴生的两者都会写在同一个scala类里面，即同一个文件里面
  * 调用 伴生() 没有new的，其实底层调用的就是伴生object里面的apply方法
  * class和object都可以定义apply方法。区别是：
  *     如果是object()  ==> 调用的是object里面的apply方法
  *     如果是val a = new classA()
  *        则 a() ==> 调用的是class里面的apply方法
  */

class ApplyApp {

  println("ApplyApp class enter")

  def applyAppClass(): Unit = {
    println("This is applyAppClass.")
  }

  println("ApplyApp class exit")

}

object ApplyApp {

  println("ApplyApp object enter")

  // apply中new了对应的class
  def apply()= {
    println("object ApplyApp apply invoked.")
    new ApplyApp    // new了一个class
  }

  var count = 0
  def incr = {
    count = count + 1
  }

  def static: Unit = {
    println("This is a static function.")
  }

  println("ApplyApp object exit")
}




object ApplyAppTest {
  def main(args: Array[String]): Unit = {

    // object直接调用function，不需要new。类十余java里面调用static的方法
    // 执行的过程首先是把ApplyApp这个object构造出来（ApplyApp）
    // 其次才是调用object ApplyApp的static方法（.static)
    // ApplyApp.static
    for (i <- 1 to 10) {
      ApplyApp.incr
    }
     println(ApplyApp.count)


    // class调用时才需要new
    val a = new ApplyApp()
    // 此时输出的是class ApplyApp的hash code
    println(a)
    a.applyAppClass()
    // class要先new出来，再调用。过程同样是首先把class构造出来，再调用方法。
    new ApplyApp().applyAppClass()


    // 这时候没有new，是先构造了一个object
    // 但是object里面有一个apply方法，apply方法中new了一个class
    // 因此b可以直接调用class的applyAppClass方法
    val b = ApplyApp()  // 其实就是在apply底层给我们new了一个class，所以我们可以直接调用该class所对应的function
    b.applyAppClass()

    println(b)
  }
}