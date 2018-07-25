package com.scala.D5

object ImplicitApp {

  def main(args: Array[String]): Unit = {

    // 定义隐式转换函数: 普通2牛逼/普通To牛逼
    // implicit 是一个
    // 传进去一只普通狗，出去的时候是牛逼的狗
    implicit def dog2JoeyDog(dog:Dog):JoeyDog = new JoeyDog(dog.name)

    val dog = new Dog("Dog A")

    dog.speak()
  }

}


// 定义一个类
class Dog(val name:String)


class JoeyDog(val name:String) {
  def speak(): Unit = {
    println("wang wang wang.")
  }
}