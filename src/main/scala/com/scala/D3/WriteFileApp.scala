/**
  * 2018-07-21 作业： 文件写操作
  */

package com.scala.D3

import java.text.SimpleDateFormat
import scala.util.Random
import java.io._

object WriteFileApp {

  def main(args: Array[String]): Unit = {

    val writer = new PrintWriter(new File("learningScala.txt"))
    for (i <- 1 to 100) {

      val domains = Array("www.ruozedata.com","www.zhibo8.com","www.dongqiudi.com")
      val domain = Random.shuffle(domains.toList).head

      val traffic = new util.Random().nextInt(9999)

      val time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format {
        System.currentTimeMillis()
      }

      writer.println(domain + "\t" + traffic + "\t" + time)

    }
    writer.close()
  }

}
