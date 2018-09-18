/**
  * 日志统计分析
  */
package com.scala.sparkcore.d1

import org.apache.spark.{SparkConf, SparkContext}

object LogApp {

  def main(args: Array[String]): Unit = {

    // spark编程模板第一步：创建SparkContext
    val sparkConf = new SparkConf().setAppName("LogApp").setMaster("local[2]")
    val sc = new SparkContext(sparkConf)

    // spark编程模板第二步：读取日志文件并进行相应的业务逻辑处理
    val count = sc.textFile("/Users/gongli/IdeaProjects/scala-study/learningScala.txt").count()
    val lines = sc.textFile("/Users/gongli/IdeaProjects/scala-study/learningScala.txt")

    // TODO... 需求1：求每个域名的流量
    /**
      * 1) 获取到日志中每条记录的域名和流量，即第一个字段和第二个字段
      *     log ==> (1,2)  tuple
      * 2) 按照域名进行分组并求和  reduceByKey(_+_)
      * 整个过程其实就是一个wordcount
      */

    // 1）拼接第一个字段和第二个字段组成一个tuple
    lines.map(x => {
      val tmp = x.split("\t")
      (tmp(0),tmp(1))
    }).take(10).foreach(println)

    // reduceByKey
    lines.map(x => {
      val tmp = x.split("\t")
      (tmp(0),tmp(1).toLong)
    }).reduceByKey(_+_).take(10).foreach(println)

    // toLong异常处理
    lines.map(x => {
      val temp = x.split("\t")
      var traffic = 0l
      try {
        traffic = temp(1).toLong
      } catch {
        case e: Exception => traffic = 0l
      }
      (temp(0),traffic)
    }).reduceByKey(_+_).take(10).foreach(println)

    // 也可以写成这样
    lines.map(x => {
      val temp = x.split("\t")
      var traffic = 0l
      try {
        traffic = temp(1).trim.toLong       // trim去空格
      } finally {
      }
      (temp(0),traffic)
    }).reduceByKey(_+_).take(10).foreach(println)

    // 如何知道整个日志处理过程中有多少条脏数据？


    // TODO... 统计每个省份的访问次数的TopN: 按IP匹配省份
    /**
      * 1) 获取IP
      * 2) 根据IP查到对应的省份 => （省份，1）
      * 3) reduceByKey(_+_)
      * 4) 排序：两次map
      */
    lines.map(x => {
      val temp = x.split("\t")
      (IpUtils.getProvince(temp(3)),1)
    }).reduceByKey(_+_).sortBy(_._2, false)     // false降序


    // spark编程模板第三步：关闭SparkContext
    sc.stop()
  }

}
