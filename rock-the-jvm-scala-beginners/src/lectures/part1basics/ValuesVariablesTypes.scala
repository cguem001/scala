package lectures.part1basics

//import com.sun.tools.corba.se.idl.constExpr.BooleanOr

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  //  VALS ARE IMMUTABLE

  // COMPILER can infer types

  val aString: String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 434534523464565L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects
  // VARS ARE IMMUTABLE


}
