package com.github.hideA88.testcsvdata

import com.github.tototoshi.csv._
import java.io._

object TestCsvData {
  def main(args: Array[String]): Unit = {
    val conf = TestCsvConf.getInstance(args)
    val (header, sample) = getSampleData(conf)
    val testData = createCopyData(sample, header, conf)
    dumpCsvData(header, testData, conf)
  }

  def getSampleData(conf: TestCsvConf): (Seq[String], Map[String, String]) = {
    val reader = CSVReader.open(new File(conf.fileName), conf.encoding)
    val it = reader.iterator
    val header =  if(it.hasNext)  it.next else List()
    val data =  if(it.hasNext)  it.next else List()
    val sample = header.zip(data).toMap
    (header, sample)
   }

  def createCopyData(sample: Map[String, String],  header: Seq[String], conf: TestCsvConf): List[List[String]]= {
    val incIds = conf.incrementIds
    val data = for( i <- 1 to conf.recordSize) yield {
      header.map{ col =>
        sample.get(col) match{
          case Some(v) if incIds.contains(col) => v + i
          case Some(v) if !incIds.contains(col) => v
          case _ => ""
        }
      }.toList
    }
    data.toList
  }

  def dumpCsvData(header: Seq[String], data: List[List[String]], conf:TestCsvConf) = {
    val file = new File(conf.outName)
    val writer = CSVWriter.open(file)
    writer.writeAll(header :: data)
    writer.close
    println("dumpCsvData")
  }
}
