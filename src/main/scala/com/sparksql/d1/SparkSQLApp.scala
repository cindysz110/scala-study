package com.sparksql.d1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object SparkSQLApp {

  def main(args: Array[String]): Unit = {

    // create a SparkSession
    val spark = SparkSession
      .builder()
      .appName("SparkSQLApp")
      .getOrCreate()

    import spark.implicits._

    // create a DF
    val df = spark.read.json("/home/hadoop/app/spark/examples/src/main/resources/people.json")
    df.show()
    df.printSchema()
    df.select("name").show()
    df.select($"name", $"age" + 1).show()
    df.filter($"age" > 21).show()
    df.groupBy("age").count().show()

    df.createOrReplaceTempView("people")
    val sqlDF = spark.sql("select * from people")
    sqlDF.show()

    df.createGlobalTempView("people")
    spark.sql("select * from global_temp.people").show()
    spark.newSession().sql("select * from global_temp.people").show()

    // create datasets
    case class Person(name:String, age:Long)

    val caseClassDS = Seq(Person("Cindy", 15)).toDS()
    caseClassDS.show()

    val primitiveDS = Seq(1,2,3).toDS()
    primitiveDS.map(_+1).collect()

    // DF => DS, 使用了 .as[class]做了一个转换
    val path = "/home/hadoop/app/spark/examples/src/main/resources/people.json"
    val peopleDS = spark.read.json(path).as[Person]
    peopleDS.show()

    // RDD => DF
    val peopleDF = spark.sparkContext
      .textFile("/home/hadoop/app/spark/examples/src/main/resources/people.txt")
      .map(_.split((",")))
      .map(attributes => Person(attributes(0), attributes(1).trim.toInt))
      .toDF()     // 这里.toDS也可以
    peopleDF.createOrReplaceTempView("people")
    val teenagersDF = spark.sql("select name,age from people where age between 13 and 19")
    teenagersDF.map(teenager => "name: " + teenager(0)).show()

    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
    teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect()


    // load datasource and save
    // datasource: Parquet File
    val usersDF = spark.read.load("/home/hadoop/app/spark/examples/src/main/resources/users.parquet")
    usersDF.select("name", "favorite_color").write.save("nameAndFavColors.parquet")

    // datasource: JSON File
    val peopleDF1 = spark.read.format("json")
      .load("/home/hadoop/app/spark/examples/src/main/resources/people.json")

    // datasource: csv File
    val peopleDFCsv = spark.read.format("csv")
      .option("sep", ";")
      .option("inferSchema", "true")
      .option("header", "true")
      .option("header", "true")
      .load("/home/hadoop/app/spark/examples/src/main/resources/people.csv")

    // run sql on files directly
    val sqlDF = spark.sql("select * from parquet.`/home/hadoop/app/spark/examples/src/main/resources/users.parquet`")

    peopleDF.write.bucketBy(42,"name").sortBy("age")

  }

}
