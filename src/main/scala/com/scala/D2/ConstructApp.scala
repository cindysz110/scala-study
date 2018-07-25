package com.scala.D2

object ConstructApp {

  def main(args: Array[String]): Unit = {

    // 创建一个对象
    val girl = new Girl("Cindy", 18,"13000000000","somewhere")
    println(girl.name + " : " + girl.age + " : " + girl.phone + " : " + girl.address)

    girl.like()

    println(girl.city)
  }

}

// 构造函数中的参数以及类中的属性（非private的）都能直接能够当做对象的属性来使用
class Girl(val name:String, val age:Int) {
  println("girl enter")

  def like(): Unit = {
    println(name + " like something.")
  }

  val city = "Shenzhen"

  // 附属构造函数：第一行必须调用主构造器或者其他的附属构造器
  var phone = ""
  def this(name:String, age:Int, phone:String) {
    this(name,age)    // 第一行，调用主构造器
    this.phone
  }

  // 再定义一个附属构造函数
  var address = ""
  def this(name:String, age:Int, phone:String, address:String) {
    this(name,age,phone)  // 这里的phone在前面的附属构造函数里面已经定义了，可以直接使用
    this.address
  }

  println("girl exit")

}

