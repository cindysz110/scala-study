/**
  * 2018-07-18 作业：scalikejdbc 读写MySQL
  */

package com.scala.D2

import scalikejdbc._
import scalikejdbc.config._

case class user(name:String, age:Int)

object QueryMySQLApp {

  def main(args: Array[String]): Unit = {

    DBs.setupAll()

    // create table
    def createTable(): Unit = {
      DB.autoCommit { implicit session =>
        sql"create table if not exists user (id int primary key auto_increment, name varchar(20) not null, age int)".execute.apply
      }
      println("Table user created.")
    }

    // insert
    def insert(name:String, age:Int): Unit = {
      DB.autoCommit { implicit session =>
        SQL("insert into user(name,age) values (?,?)").bind(s"$name",s"$age").update().apply()
      }
      println("Data inserted into table user.")
    }

    // select
    def select() = {
      DB.readOnly { implicit session =>
        //val sql = SQL("select * from people ").map(rs => (rs.string("name"), rs.int("age"))).toList().apply()
        SQL("select name,age from user").map(rs => user(rs.string("name"), rs.int("age"))).list().apply()
      }
    }

    createTable()
    println("Table user created.")

    insert("name1", 1)
    insert("name2", 2)
    insert("name3", 3)
    insert("name4", 4)
    insert("name5", 5)

    val users = select()
    for (user <- users) {println(user.name + " : " + user.age)}

    DBs.closeAll()
  }

}
