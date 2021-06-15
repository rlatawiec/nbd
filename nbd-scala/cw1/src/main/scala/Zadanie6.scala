object Zadanie6 extends App {

  def printTuple[A, B, C](t: (A, B, C)): Unit =
    println(t)

  val t = (1, "ABC", true)

  printTuple(t)
}
