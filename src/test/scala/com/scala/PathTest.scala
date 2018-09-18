package com.scala

object PathTest {

  def main(args: Array[String]): Unit = {

    val url = "http://domain/a/b/c/d.mp4?x=y&w=z................."

    println(getResource(url))

  }

  // 整理成一个函数
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


//def getResource(url:String) {
//
//}