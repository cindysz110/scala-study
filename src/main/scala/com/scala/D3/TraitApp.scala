package com.scala.D3

// Logging这个方法是在spark的依赖里面的
import org.apache.spark.internal.Logging


/**
  * 一个类实现trait的方法，需要使用关键字with
  * 第一个使用extends，后续的都是用with
  *
  * TraitApp实现了2个接口，第一个是Logging，第二个是Serializable。
  * 如果后面还有多个，继续在后面跟with xxx
  *
  *
  * 其他的地方跟抽象类基本一样
  */
object TraitApp extends Logging with Serializable {


}
