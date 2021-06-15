object Zadanie2 extends App {

  class KontoBankowe(val stanKonta: Long = 0) {

    def wplata: Unit = ???
    def wyplata: Unit = ???

  }

  val konto = new KontoBankowe(1000)
  val kontoDefault = new KontoBankowe()

  println(konto.stanKonta)
  println(kontoDefault.stanKonta)

}
