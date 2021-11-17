package lectures.part1basics

object CBNvsCBV extends App{

  /**
   * This method evaluate the function once, passing and printing the same value twice
   * */
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  /**
   * This method evaluate the function everytime, therefore by name will have to different values
   * */
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // it tells the current time of the system in nanoseconds
  calledByName(System.nanoTime()) // it tells the current time of the system in nanoseconds

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x) // This function will print the first parameter

//  printFirst(infinite(), 34) this line will crass with java.lang.StackOverflowError
  printFirst(34, infinite()) // this works because the expresion => delays the evaluation until is used and because is never used, it will work


}
