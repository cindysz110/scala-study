/**
  * 2018-07-22 作业：Scala 实现word count
  */

package com.scala.D4

object WordCountApp {

  def main(args: Array[String]): Unit = {

    val lines = Array("hello hadoop scala hdfs", "hello scala sqoop hadoop", "hello hdfs hive", "hello scala")

//    // Map then flatten
//    val words = lines.flatMap(_.split(" "))
//
//    // word => (word, 1)
//    val wordToTuple = words.map((_,1))
//
//    // groupby key
//    val grouped = wordToTuple.groupBy(_._1)
//
//    // tuple(key, length)
//    val wordList = grouped.map(t => (t._1,t._2.length))
//
//    // sort by value(count)
//    println(wordList.toList.sortBy(_._2))
//
//    // reverse
//    println(wordList.toList.sortBy(_._2).reverse)

    val words = lines
      .flatMap(_.split(" "))      // map then fatten
      .map((_,1))                         // word => (word,1)
      .groupBy(_._1)                      // group by key
      .map(t => (t._1,t._2.length))       // new tuple(key,length)
      .toList                             // tuple to List
      .sortBy(_._2)                       // sort by value
      .reverse                            // reverse

    for (ele <- words) {
      println(ele)
    }
  }

}
