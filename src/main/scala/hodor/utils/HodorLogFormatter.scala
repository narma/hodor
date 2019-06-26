package hodor.utils

import wvlet.log._
import wvlet.log.LogFormatter._
import wvlet.log.LogTimestampFormatter.formatTimestamp

object HodorLogFormatter extends LogFormatter {
    override def formatLog(r: LogRecord): String = {
      val loc =
        r.source
          .map(source => s" ${withColor(Console.BLUE, s"- (${source.fileLoc})")}")
          .getOrElse("")
  
      val logTag = highlightLog(r.level, r.level.name)
      val log =
        f"${withColor(Console.BLUE, formatTimestamp(r.getMillis))} ${logTag}%14s [${withColor(
          Console.WHITE,
          r.leafLoggerName)}] ${highlightLog(r.level, r.getMessage)} ${loc}"
      appendStackTrace(log, r)
    }
}