package com.scala.D2

object AbstractApp {

  def main(args: Array[String]): Unit = {

    // 因为抽象类Animal是不能直接被使用的，所以new一个它的子类
    val dog = new Dog
    dog.speak
  }

}

/**
  * 抽象类的定义 abstract
  * 抽象类可以有属性，有方法
  * 属性和方法都只是定义，没有实现
  * 这样的抽象类是不能直接被使用的
  */
abstract class Animal {
  // 属性或方法只有定义没有实现
  var name:String
  var age:Int
  def speak
}

/**
  * 定义一个字类继承上面的抽象类，这个子类要么再被定义成抽象类，或者实现父类的spark方法
  * 在Dog上面按住ctrl+回车，选择实现这个方法(Implement methods)，选中所有的方法点OK
  * 再给属性赋值，方法重写
  * 子类重写父类中的方法或者属性，override可以省略不写
  */
class Dog extends Animal {

  // 重写父类的属性
  override var name: String = "Rich"
  override var age: Int = 1

  // 重写父类的方法
  override def speak: Unit = {
    println("wang wang wang")
  }
}