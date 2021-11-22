package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0 ) {
    //This class is created inside MethodNotations to avoid conflicts with Person in OOBasics

    def likes(movie: String): Boolean = movie == favoriteMovie
//    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(name: String): Person = new Person(this.name + name, favoriteMovie)
    def unary_! : String = s"$name, what the heck?"
    def unary_+ : Person =  new Person (name, favoriteMovie, age+1 )
    def isAlive: Boolean = true //postfix
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie" // apply
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(parameter: String) = s"$name learns $parameter"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // line 12 and 13 are the same
  println(mary likes "Inception") // equivalent
  // this is call infix notation or operator notation, only works with methods which have only one parameter
  // this is call syntactic sugar -> println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
//  println(mary.hangOutWith(tom))
//  println(mary hangOutWith tom) equivalent with line 20
  println(mary + tom) // you can use operators to name methods
  println(mary.+(tom)) // equivalent with line 22

  println(1 + 2)
  println(1.+(2))

  // Bottom line is ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation -> it works with methods with no arguments
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) //equivalent with line 50

  println((mary + " (the Rockstar)")())
  println((mary + " (the Rockstar)").apply()) //equivalent with line 59
  println((+mary).age)

  println(mary.learns("Scala"))
  println(mary learns "Scala")
  println(mary learnsScala)
  println(mary.apply(2))
  println(mary(2)) // equivalent with line 66

  /*
    1. Overload the + operator from line 12 which receives a string and it will return a new Person with a Nickname
    mary + "the rockstar" => new Person "Mary (the rockstar)" and the same movie
    overload infix operator

    2. Add an age to the Person class
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class, it receives a string parameter => "Mary learns parameter"
       Add a learnsScala method, without paramaters. calls learns method with "Scala".
       Use it in postfix notation.

    4. Overload the apply method to receive a number and return a string
    mary.apply(2) => "Mary watched Inception 2 times"
   */




}
