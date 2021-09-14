package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // 1 + 2 IS AN EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  // Relational operations
  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ...... side effects
  println(aVariable)

  // Instructions vs Expressions

}
