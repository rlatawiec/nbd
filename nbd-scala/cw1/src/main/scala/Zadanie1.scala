import inputs.daysOfTheWeek

object Zadanie1 extends App {


  def joinInForLoop(s: List[String]): String = {
    var result = s.head
    for (el <- s.tail) {
      result += s",$el"
    }
    result
  }

  def joinInForLoopWithFilter(s: List[String]): String = {
    var result = s.head
    for (el <- s.tail if (el.startsWith("P"))) {
      result += s",$el"
    }
    result
  }

  def joinInWhileLoop(s: List[String]): String = {
    val listSize = s.size
    var i = 1
    var result = s.head
    while (i < listSize) {
      result += s",${s(i)}"
      i += 1
    }
    result
  }

  println(joinInForLoop(daysOfTheWeek))
  println(joinInForLoopWithFilter(daysOfTheWeek))
  println(joinInWhileLoop(daysOfTheWeek))



}
