import com.github.tototoshi.csv._
import java.io._
object TestCsvData {
  def main(args: Array[String]): Unit = {
    val conf = TestCsvConf.getInstance(args)
    val reader = CSVReader.open(new File(conf.fileName), conf.encoding)
    val it = reader.iterator
    val header =  if(it.hasNext)  it.next else List()
    val data =  if(it.hasNext)  it.next else List()
    val sample = header.foldLeft(Map()){ (map, v) => }
    val testData = createCopyData(sample, header, conf)
    dumpCsvData(header, testData)
  }

  def createCopyData(sample: Map[String, String], header: Seq[String], conf: TestCsvConf): List[List[String]]= {
    val incIds = conf.incrementIds
    val data =  for( i <- 1 to conf.recordSize; col <- header) yield {
      if(incIds.contains(col)){
        col+i
      }else{
        col
      }
    }
    println("data: "+data)
    return List(List("test"))
  }

  def dumpCsvData(header: Seq[String], data: List[List[String]]) = {
    println("dumpCsvData")
  }
}
