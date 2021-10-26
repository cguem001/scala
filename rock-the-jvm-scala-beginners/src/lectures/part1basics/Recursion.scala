package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n -1)
      println("Computed factorial of " + n)

      result
    }

//  println(factorial(10))
//  println(factorial(5000)) --> This will crash the program

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recorsive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = factorialHelper(6, 7 * 8 * 9 * 10 * 1)
    = factorialHelper(5, 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(4, 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(3, 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(1, 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10

   */

//  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USER _TAIL_RECURSION/

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

//  1. Concatenate a string n times
//  def stringConcatenationFunction(aString: String, n: Int): String = {
//    def stringAccumulator(x: Int, accumulator: Int): String = {
//      if (x <= 1) accumulator
//      else stringAccumulator(x-1, aString * accumulator)
//    }
//  }

  def stringConcatenation(aString: String, n: Int, accumulator: String): String = {
    if (n <=0) accumulator
    else stringConcatenation(aString, n-1, aString + accumulator)
  }


  println(stringConcatenation("carlos", 7, " "))
}
