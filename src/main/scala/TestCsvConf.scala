case class TestCsvConf(encoding: String, fileName: String,
  incrementIds: List[String])

object  TestCsvConf {
  def getInstance(args: Array[String]): TestCsvConf = {
    new TestCsvConf("sjis", "sample.csv", List("id", "title"))
  }
}
