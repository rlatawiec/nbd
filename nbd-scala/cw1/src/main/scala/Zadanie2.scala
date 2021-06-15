import scala.annotation.tailrec

object Zadanie2 extends App {

  import inputs.daysOfTheWeek

  def joinRecursive(xs: List[String]): String = {
    @tailrec
    def go(s: String, xs: List[String]): (String, List[String]) = {
      xs match {
        case Nil => (s, xs)
        case x :: xs => go(s"$s, $x", xs)
      }
    }

    go(xs.head, xs.tail)._1
  }

  def joinRecursiveReverse(xs: List[String]): String = {
    @tailrec
    def go(s: String, xs: List[String]): (String, List[String]) = {
      xs match {
        case Nil => (s, xs)
        case x :: xs => go(s"$x, $s", xs)
      }
    }

    go(xs.head, xs.tail)._1
  }

  println(joinRecursive(daysOfTheWeek))
  println(joinRecursiveReverse(daysOfTheWeek))
}
