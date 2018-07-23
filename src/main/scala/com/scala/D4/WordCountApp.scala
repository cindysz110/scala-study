package com.scala.D4

object WordCountApp {

  def main(args: Array[String]): Unit = {

    val lines = Array("hello hadoop scala hdfs", "hello scala sqoop hadoop", "hello hdfs hive", "hello scala")

    // Map then flatten
    val words = lines.flatMap(_.split(" "))

    // word => (word, 1)
    val wordToTuple = words.map((_,1))

    // groupby key
    val grouped = wordToTuple.groupBy(_._1)

    // tuple(key, length)
    val wordList = grouped.map(t => (t._1,t._2.length))

    // sort by value(count)
    println(wordList.toList.sortBy(_._2))

    // reverse
    println(wordList.toList.sortBy(_._2).reverse)
  }

}
