case class TestCsvConf private(encoding: String,
   fileName: String,
   recordSize: Int,
   incrementIds: List[String]
 )

object  TestCsvConf {
  def getInstance(args: Array[String]): TestCsvConf = {
    new TestCsvConf("sjis", "sample.csv", 10,  List("id", "title"))
  }
}
