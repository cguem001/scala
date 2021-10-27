package lectures.part1basics

import lectures.part1basics.Functions.{fibonacci, isPrime}

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
  @tailrec
  def stringConcatenation(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else stringConcatenation(aString, n -1, aString + accumulator)


//  2. IsPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t-1, n % t != 0 && isStillPrime)
    }
    isPrimeUntil(n / 2, true)
  }
//  println(isPrime(629))

//  3. Fibonacci function, tail recursive
  def fibonacciTailRec(n: Int, accumulator: Int): Int =
    if (n<=1) n
    else fibonacciTailRec(n - 1 + n -2, accumulator * n-1)

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)

  }

  println(fibonacci(12))
//  println(fibonacciTailRec(12, 1))

//  println(stringConcatenation("carlos", 7, " "))

}
