package com.sparksql.d1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object SparkSQLApp {

  def main(args: Array[String]): Unit = {

    // create a SparkSession
    val spark = SparkSession
      .builder()
      .master("local[2]")
      .appName("SparkSQLApp")
      .getOrCreate()

    import spark.implicits._

    // create a DF
//    val df = spark.read.json("/Users/gongli/Downloads/resources/people.json")
//    df.show()

    //读取文件系统上的文件并创建RDD
    val info = spark.sparkContext.textFile("/Users/gongli/Downloads/resources/infos.txt")
    info.collect().foreach(println)

    //TODO: RDD=>DF(RDD没有schema，DF有schema，这时候就要用到case class了）
//    case class Info(id:Int, name:String, age:Int)     //这个case class是有schema信息的，写在下面

    //我们的infos.txt文件里面有三行数据，对应转成DF应该也是三条记录。把RDD中每条数据解析（map）出来：
    //读取每一行的数据，采用逗号分割，分割出来是一个数组，然后把每一行对应的元素对照Info类做一下类型转换（因为读进来的元素全部都是string）
    //最后再转成DF，注意toDF选择时不需要选择带schema类型的
    import spark.implicits._
    val infoDF = info.map(_.split(",")).map(x => Info(x(0).toInt, x(1), x(2).toInt)).toDF()
    infoDF.show(false)







//    df.show()
//    df.printSchema()
//    df.select("name").show()
//    df.select($"name", $"age" + 1).show()
//    df.filter($"age" > 21).show()
//    df.groupBy("age").count().show()
//
//    df.createOrReplaceTempView("people")
//    val sqlDF = spark.sql("select * from people")
//    sqlDF.show()
//
//    df.createGlobalTempView("people")
//    spark.sql("select * from global_temp.people").show()
//    spark.newSession().sql("select * from global_temp.people").show()
//
//    // create datasets
//    case class Person(name:String, age:Long)
//
//    val caseClassDS = Seq(Person("Cindy", 15)).toDS()
//    caseClassDS.show()
//
//    val primitiveDS = Seq(1,2,3).toDS()
//    primitiveDS.map(_+1).collect()
//
//    // DF => DS, 使用了 .as[class]做了一个转换
//    val path = "/home/hadoop/app/spark/examples/src/main/resources/people.json"
//    val peopleDS = spark.read.json(path).as[Person]
//    peopleDS.show()
//
//    // RDD => DF
//    val peopleDF = spark.sparkContext
//      .textFile("/home/hadoop/app/spark/examples/src/main/resources/people.txt")
//      .map(_.split((",")))
//      .map(attributes => Person(attributes(0), attributes(1).trim.toInt))
//      .toDF()     // 这里.toDS也可以
//    peopleDF.createOrReplaceTempView("people")
//    val teenagersDF = spark.sql("select name,age from people where age between 13 and 19")
//    teenagersDF.map(teenager => "name: " + teenager(0)).show()
//
//    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
//    teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect()
//
//
//    // load datasource and save
//    // datasource: Parquet File
//    val usersDF = spark.read.load("/home/hadoop/app/spark/examples/src/main/resources/users.parquet")
//    usersDF.select("name", "favorite_color").write.save("nameAndFavColors.parquet")
//
//    // datasource: JSON File
//    val peopleDF1 = spark.read.format("json")
//      .load("/home/hadoop/app/spark/examples/src/main/resources/people.json")
//
//    // datasource: csv File
//    val peopleDFCsv = spark.read.format("csv")
//      .option("sep", ";")
//      .option("inferSchema", "true")
//      .option("header", "true")
//      .option("header", "true")
//      .load("/home/hadoop/app/spark/examples/src/main/resources/people.csv")
//
//    // run sql on files directly
//    val sqlDF = spark.sql("select * from parquet.`/home/hadoop/app/spark/examples/src/main/resources/users.parquet`")
//
//    peopleDF.write.bucketBy(42,"name").sortBy("age")

    spark.close()

  }

  case class Info(id:Int, name:String, age:Int)
}
