1 + 1

val x = 42

x * x

def and(x: Boolean, y:Boolean): Boolean =
  if x then y else false

and(true, false)

and(true, true)

def loop: Boolean = loop

//and(false, loop)

def andd(x: Boolean, y: => Boolean): Boolean =
  if x then y else false

andd(false, loop)

def abs(x:Double) = if (x < 0) -x else x

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def isGoodEnough(guess: Double, x: Double) = ???

def improve(guess: Double, x: Double) =(guess + x / guess) / 2

def sqrt(x: Double) = sqrtIter(1.0, x)


sqrtIter(1, 2)
//sqrtIter(1, 0.1e-20)

/*
0.001

0.1e-20

1.0e20

1.0e50
*/

def isGoodEndough(guess: Double, x: Double) =
  abs(guess * guess -x) < 0.001
