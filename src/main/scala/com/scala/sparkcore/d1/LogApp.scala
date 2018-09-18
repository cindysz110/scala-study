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


    // TODO... 求每个域名下访问数最多的文件资源（访问全路径http://domain/a/b/c/d.mp4?x=y&w=z）   窗口函数  结果可以画热力图，密集度
    /**
      * 截取资源的一部分，其中域名domain在第一个字段已经有了，资源其实是：/a/b/c/d.mp4, domian后第一个斜杠后到第一个问号之前的内容
      */
    lines.map(x => {
      val temp = x.split("\t")
      getResource(temp(12))
    }).take(100).foreach(println)


    lines.map(x => {
      val temp = x.split("\t")
      ((temp(0), getResource(temp(12))),1)    // （（域名，资源），1）
    }).reduceByKey(_+_).groupBy(_._1._1)
        .mapValues(_.toList.sortBy(_._2).reverse.take(10))
        .map(_._2)
        .collect().foreach(println)

      //.take(10).foreach(println)


    // spark编程模板第三步：关闭SparkContext
    sc.stop()
  }

  def getResource(url:String) = {

    // 把开头两个斜杠去掉
    val pathTemp = url.replaceFirst("//", "")
    var pathIndex = pathTemp.indexOf("/")

    var path = ""
    if(pathIndex != -1) {
      path = pathTemp.substring(pathIndex)
      pathIndex = path.indexOf("?")
      if (pathIndex != -1) {
        path = path.substring(0, pathIndex) // 字符串截取
      }
    }
    path
  }
}
