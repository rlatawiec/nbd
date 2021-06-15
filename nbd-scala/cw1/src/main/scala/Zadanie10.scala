object Zadanie10 extends App {

  val in = List(-10, -8, -5, -2, 2, 5, 8, 10, 12, 15, 20)

  def qwe(xs: List[Int]): List[Int] = {
    xs.view
      .filter(x => (x < 12) && (x > -5))
      .map(_.abs)
  }.toList

  println(qwe(in))
}
