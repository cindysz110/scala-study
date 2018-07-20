package com.scala

import scalikejdbc._
import scalikejdbc.config._


object ScalaLikeJdbc {

  def main(args: Array[String]): Unit = {

    DBs.setupAll()

    val memberIds = DB readOnly { implicit session =>
      sql"select id from people".map(_.long(1)).list.apply()
    }

    println(memberIds)

    DBs.closeAll()

    println("-------------------------------")

  }

}
