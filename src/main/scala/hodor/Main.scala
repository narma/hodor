package hodor

import wvlet.log._
import hodor.job.DataExplorer
import hodor.utils.HodorLogFormatter

object Main extends App with LogSupport {
  def inputFilePath(): String = args.headOption.getOrElse("/tmp/hello.txt")
  
  Logger.setDefaultFormatter(HodorLogFormatter)
  Logger.scanLogLevels
  
  info("start job")

  DataExplorer.linesCountJob(inputFilePath)
  
  info(s"job finished, bye bye")
}
