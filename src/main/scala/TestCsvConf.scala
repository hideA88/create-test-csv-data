package com.github.hideA88.testcsvdata

import com.typesafe.config.ConfigFactory
import scala.collection.JavaConverters._
import java.io._

case class TestCsvConf private(encoding: String,
   fileName: String,
   outName: String,
   recordSize: Int,
   incrementIds: List[String]
 )

object  TestCsvConf {
  def getInstance(args: Array[String]): TestCsvConf = {
    var confFile = new File("./application.conf")
    val config = if(confFile.exists()){
       ConfigFactory.parseFile(confFile).getConfig("conf")
    }else{
       ConfigFactory.load().getConfig("conf") // defaultとしてsrc/main/resources/application.conf が読まれる
    }
    val encoding = config.getString("encoding")
    val file = config.getString("file")
    val outName = config.getString("outName")
    val recordSize = config.getInt("recordSize")
    val incrementIds = config.getStringList("incrementIds").asScala.toList
    new TestCsvConf(encoding, file, outName, recordSize,  incrementIds)
  }
}
