package com.scala.D2

object ConstructApp {

  def main(args: Array[String]): Unit = {

    // 创建一个对象
    val girl = new Girl("Cindy", 18,"13000000000","somewhere")
    println(girl.name + " : " + girl.age + " : " + girl.phone + " : " + girl.address)

    girl.like()

    println(girl.city)

    val littlegirl = new littleGirl("girl", 10, "computer")
    println(littlegirl.name + " : " + littlegirl.age + " : "  + littlegirl.major)

    println(littlegirl)
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

// 类的继承
/**
  *
  * 类的继承
  * littleGirl的前半部分littleGirl(name:String, age:Int)是一个主构造器，
  * 继承了Girl这个class
  * 并且littleGirl还加入了自己的参数major
  *
  * 发生继承时，当我们创建子对象的时候，首先会调用父类的构造方法，然后才是调用子类的构造方法
  * 如果子类里面的属性（入参）不是父类里面已经有的，前面要加val修饰符，否则外面是访问不到的
  */
class littleGirl(name:String, age:Int, val major :String) extends Girl(name,age) {

  println("littleGirl enter")

  // toString是scala内置的一个object类的方法，如果想重写父类中已有的方法时，一定需要添加overwrite修饰符
  override def toString = "littleGirl toString"


  println("littleGirl exit")
}
