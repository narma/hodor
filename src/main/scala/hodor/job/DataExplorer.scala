package hodor.job

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import wvlet.log.LogSupport

object DataExplorer extends LogSupport {

  def initSparkContext(): SparkContext = new SparkContext(
      new SparkConf().setAppName("dataExplorer"))

  def linesCountJob(path: String): Unit = {
    val sc = initSparkContext()
    val result = sc.textFile(path).count
    info(s"Lines count of $path: $result")
  }

}
