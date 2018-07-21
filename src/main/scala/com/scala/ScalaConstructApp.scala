/**
  * 构造函数
  */

package com.scala

object ScalaConstructApp {

  def main(args: Array[String]): Unit = {

//    val girl = new Girl("name", 18)
//    println(girl.name + " : " + girl.age)
//
//    // 构造函数中的参数以及类中的属性（非private的）都直接能够当做对象的属性来使用
//    println(girl.name + " : " + girl.age + " : " + girl.city)


//    val girl = new Girl("name", 18, "13800000000")
//    println(girl.name + " : " + girl.age + " : " + girl.phone)

    val girl = new Girl("name", 18, "13800000000", "Longhua")
    println(girl.name + " : " + girl.age + " : " + girl.phone + " : " + girl.address)

  }

}

// 构造函数：定义类时括号里传进去的参数
// 构造函数中的参数以及类中的属性（非private的）都直接能够当做对象的属性来使用

// 主构造函数
class Girl(val name:String, val age:Int) {

  println("Girl in")

  def like(): Unit = {
    println(name + "like fruit")
  }

  val city = "Shenzhen"


  var phone = ""
  // 附属构造函数：第一行必须调用主构造器或者其他的附属构造器
  def this(name:String, age:Int, phone:String) {
    this(name, age)
    this.phone = phone
  }


  // 附属构造函数，上一个附属构造函数里已经有的参数可以直接传进来
  var address = ""
  def this(name:String, age:Int, phone:String, address:String) {
    this(name, age, phone)
    this.address = address
  }



  println("Girl out")


}