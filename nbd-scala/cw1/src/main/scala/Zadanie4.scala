object Zadanie4 extends App {

  import inputs.daysOfTheWeek

  def joinFoldL(xs: List[String]): String =
    xs.tail.foldLeft(xs.head)((xs, x) => s"$xs, $x")

  def joinFoldR(xs: Array[String]): String =
    xs.init.foldRight(xs.last)((xs, x) => s"$xs, $x")

  def joinFoldLFilter(xs: List[String]): String =
    xs.tail.view
      .filter(_.startsWith("P"))
      .foldLeft(xs.head)((xs, x) => s"$xs, $x")

  println(joinFoldL(daysOfTheWeek))
  println(joinFoldR(daysOfTheWeek.toArray))
  println(joinFoldLFilter(daysOfTheWeek))

}
