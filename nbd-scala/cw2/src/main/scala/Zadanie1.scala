object Zadanie1 extends App {

  private val weekdays = List(
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
  )
  private val weekends = List(
    "Saturday",
    "Sunday"
  )

  def workOrWeekend(day: String): String =
    day match {
      case weekday if weekdays.contains(weekday) => "Praca"
      case weekend if weekends.contains(weekend) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }

  ("BadDay" :: weekdays ++ weekends)
    .map(workOrWeekend)
    .foreach(println)

}
