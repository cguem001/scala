package lectures.part1basics

object Functions extends App {

  def aFunction (a: String, b: Int): String = {
    /**
     * aFunction --> name of the function
     * a: String --> parameter with name a and type String
     * b: Int --> parameter with name b and type Int
     * : String = --> function returns String
     * */
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction() )
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1 * 2 * 3 * 4 * .. * n
    3. A Fibonacci function
       f(1) = 1
       f(2) = 1
       f(3) = f(n - 1) + f(n - 2)
    4. Test if a number is prime.
  */

//  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  def greatingForKids(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greatingForKids("Carlos", 39))

//  2. Factorial function 1 * 2 * 3 * 4 * .. * n
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))

//  3. A Fibonacci function
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)

  }

  println(fibonacci(12))

//  4. Test if a number is prime.
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
}
