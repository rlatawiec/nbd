object Zadanie9 extends App {

  def incrementList(xs: List[Int]): List[Int] =
    xs.map(_ + 1)

  val in = List(1, 2, 3)

  println(incrementList(in))

}
