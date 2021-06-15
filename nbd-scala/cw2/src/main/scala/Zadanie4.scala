object Zadanie4 extends App {


  def applyThreeTimes(n: Int)(f: Int => Int): Int =
    f.andThen(f).andThen(f)(n)

  applyThreeTimes(0) { n: Int =>
    println(s"Called with $n")
    n + 3
  }
}
