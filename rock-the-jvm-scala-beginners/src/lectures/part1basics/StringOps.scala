package lectures.part1basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // it will print 'l'
  println(str.substring(7, 11)) // string from index 7 inclusive to index 11 exclusive. OUTPUT: "I am"
  println(str.split(" ").toList) // List(Hello,, I, am, learning, Scala)

  val myValue: List[String] = str.split(" ").toList

  println(myValue.size) // the size is 5

  println(str.startsWith("Hello")) // it will return true or false, in this case it will be true
  println(str.replace(' ', '-')) // Hello,-I-am-learning-Scala
  println(str.toLowerCase()) // hello, i am learning scala
  println(str.length) // 26 is the length of the string

  val aNumberString = "2"
  val aNumber = aNumberString.toInt // this will convert the string "2" to the integer 2
  println('a' +: aNumberString :+ 'z') // these are prepending and appending operators, they are scala specific
  // output will be "a2z"
  println(str.reverse) // this is a scala specific utility function. OUTPUT: "alacS gninrael ma I ,olleH"
  println(str.take(2)) // it will take the first 2 characters out of the string. OUTPUT: He

  // Scala-specific: String interpolators.

  // S-interpolators
  val name = "Carlos"
  val age = 12
  val greeting = s"Hello, my nam is $name and I am $age years old" // you need to put s before the string for interpolation
  val anotherGreeting = s"Hello, my nam is $name and I will be turning ${age + 1} years old"
//  interpolators strings also can evaluate complex expressions ^
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute" // 2.2f means 2 characters total, minimum and
//  2 decimal precision.

  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped") // now the \n will be interpolate. the output will be
//  This is a
//  newline


}
