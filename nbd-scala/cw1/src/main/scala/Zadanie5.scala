object Zadanie5 extends App {

  import inputs._

  val discountPrices = prices.view.mapValues(_ * 0.9)
  println(discountPrices.toMap)

}
