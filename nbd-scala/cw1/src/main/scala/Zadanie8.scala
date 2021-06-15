object Zadanie8 extends App {

  def filterZeros(in: List[Int]): List[Int] = {
    in match {
      case Nil => Nil
      case x :: xs if x == 0 => filterZeros(xs)
      case x :: xs => x :: (filterZeros(xs))
    }
  }

  def filterCPS[A](in: List[A])(cond: A => Boolean): List[A] = {
    @scala.annotation.tailrec
    def go(k: List[A] => List[A], xs: List[A]): List[A] = xs match {
      case Nil => k(Nil)
      case x :: xs if cond(x) => go(k, xs)
      case x :: xs => go((rest: List[A]) => k(x :: rest), xs)
    }

    go(identity, in)
  }

  val testInput: List[Int] = List(1, 0, 2, 0, 3, 0)
  println(filterZeros(testInput))
  println(filterCPS(testInput)(_ == 0))

}
