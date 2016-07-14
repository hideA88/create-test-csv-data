import com.github.tototoshi.csv._
import java.io._
object TestCsvData {
  def main(args: Array[String]): Unit = {
    val f = new TestCsvConf("sjis", "hoge.csv", List("id", "title"))
    println(f)
    val conf = TestCsvConf.getInstance(args)
    val reader = CSVReader.open(new File(conf.fileName), conf.encoding)
    val it = reader.iterator
    val header =  if(it.hasNext)  it.next else List()
    val sample =  if(it.hasNext)  it.next else List()
    val data = createCopyData(sample, header, conf)
    dumpCsvData(header, data)
  }

  def createCopyData(sample: Seq[String], header: Seq[String], conf: TestCsvConf): List[List[String]]= {

    return List(List("test"))
  }

  def dumpCsvData(header: Seq[String], data: List[List[String]]) = {
    println("dumpCsvData")
  }
}
