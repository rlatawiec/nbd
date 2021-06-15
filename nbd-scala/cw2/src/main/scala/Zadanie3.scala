object Zadanie3 extends App {

  case class Osoba(imie: String, nazwisko: String)

  private val john = Osoba("John", "Smith")
  private val mike = Osoba("Mikey", "Mike")
  private val other = Osoba("Other", "Person")

  def greet(person: Osoba): String =
    person match {
      case Osoba("John", "Smith") => "Good morning John"
      case Osoba("Mikey", "Mike") => "'Sup Mikey"
      case o => s"Hi, ${o.imie} ${o.nazwisko}"
    }

  println(greet(john))
  println(greet(mike))
  println(greet(other))

}
