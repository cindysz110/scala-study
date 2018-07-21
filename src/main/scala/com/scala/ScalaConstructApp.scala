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

    println("--------------")
    val cindy = new Cindy("Cindy", 10, "Computer")
    println(cindy)  // 当下面Cindy中的toSting方法没有被overwrite时，打印的结果是对象的hash：包名+类名+hash code（即：com.scala.Cindy@53b32d7）
    //println(cindy.name + " : " + cindy.age + " : " + cindy.major)

    println("======================")

  }

}

// 构造函数：定义类时括号里传进去的参数
// 构造函数中的参数以及类中的属性（非private的）都直接能够当做对象的属性来使用

// 主构造函数
class Girl(val name:String, val age:Int) {

  println("Girl enter")

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

  println("Girl exit")

}


/**
  *
  * 类的继承
  * 继承：发生在子和父类之间的
  * 继承的时候，当我们创建子对象的时候，其实对先调用父类的构造方法
  * 当调用的参数不是父类里面已经有的参数时，前面必须要加修饰符（val），否则子类在被调用的时候该参数是访问不到的
  */
class Cindy(name:String, age:Int, val major:String) extends Girl(name,age) {      // 继承主构造器

  println("Cindy enter")

  // 需要overwrite修饰符，如果想重写父类中已有的方法时，一定需要添加overwrite修饰符
  override def toString = "cindy toString"    // toString在java中是一个object类的方法，一个特殊的方法

  println("Cindy exit")
}



/**
  * 抽象类
  * 类中有一个或者多个方法没有实现：只有定义，没有实现
  * 是不能直接使用的，必须要通过实现了该抽象类的属性或者方法来使用
  */