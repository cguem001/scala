package example

import scala.annotation.tailrec

object MyPractice extends App {

//  val myMap = Map("a" -> 42, "b" -> 43)
//
//  def getMapValue(s: String): String = {
//    myMap get s match {
//      case Some(nb) => "Value found: " + nb
//      case None => "Not value found"
//    }
//  }
//
//  println(getMapValue("f"))
//
//  // same getMapValue written differently
//  def getMapValue2(s: String): String = {
//    myMap.get(s).map("Value found: " + _).getOrElse("Not value found")
//  }
//
//  println(getMapValue2("a"))
//
//  val options: List[Option[Char]] = Some('a') :: None :: Some('b') :: Nil
////  val chars: List[Char] = pairs.map(p => p match {
////    case Some(ch) => ch
////    case None => 'z'
////  })
//
////  val chars: List[Char] = pairs.map {
////    case Some(ch) => ch
////    case None => 'z'
////  }

def square(x: Double): Double = x * x
def abs(x: Double) = if x > 0 then x else -x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if isGoodEnough(guess) then guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(square(guess) - x) < 0.001

    sqrtIter(1.0)
  }

println(sqrt(2))

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

val myVal: Int = 17 * 16

  println("This is the modulus: " + myVal)

  def factorial(n: Int): Int =
    if n ==0 then 1 else n * factorial(n -1)

  @tailrec
  def factorialTail(n: Int, tail: Int): Int =
    if n == 0 then tail else factorialTail(n - 1, n * tail)

  println(factorialTail(7, 1))
}




