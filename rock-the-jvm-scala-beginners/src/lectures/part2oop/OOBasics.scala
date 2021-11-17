package lectures.part2oop

import java.io.Writer

object OOBasics extends App {
  val person = new Person("Paco", 39) // to instantiate Person class
  println(person.age) // 39
  person.greet("Carlos")
  person.greet()


  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge) // it returns true
  println(novel.isWrittenBy(imposter)) // it returns false

  val counter = new Counter
  counter.increase.print
  counter.increase.increase.increase.print
  counter.increase(10).print


}

// A class organizes data and behavior that is code
// Instantiation is concrete realizations in memory. That is actual memory spaces that conform to the code and the data
// structure that the class describes

class Person(name: String, val age: Int = 0) { // this is the constructor
  // A constructor says basically that every single instance of Person must be constructed by passing in name and age
  // class parameters are NOT FIELDS, to make the fields add the keyword val before

  //  body
  val x = 2 // this is a field, so it can be access it from object like person.x
  println(1 + 3)

  def greet(name: String) = println(s"${this.name} says: Hi, $name")

  // overloading. it means defining method with the same name but different signatures
  def greet() = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Fermin")
}

/*
 Novel and a Writer class

 Writer: first name, surname, year of birth
  - method fullname which returns the concatenation of fullname and lastName

 Novel: name, year of release, author (which is an instance of type writer)
  - authorAge, returns the age of the author at the year of release
  - is WrittenBy(author)
  - copy (new year of release) = new instance of Novel

 */

/*
 Counter class
 - receives an int value
 - method current count, returns the current count
 - method to increment/decrement => new Counter
 - overload inc/dec to receive an amount
 */

class Writer(name: String, surname: String, val year: Int) {
  def fullName = println(s"$name $surname")
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  val writer = new Writer("William","Shakespeare", 1500)

  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val valueInt : Int = 0) {
//  def currentCount = valueInt
//  def increase = new Counter(currentCount + 1)
  def increase = {
    println("incrementing")
    new Counter(valueInt + 1) // immutability -> it means instances are fixed they cannot be modified inside
  //  if you wanted to modify the contents of an instance, you actually need to return a new instance
  }
  def decrease = {
    println("decrementing")
    new Counter(valueInt - 1)
  }

  def increase(n: Int): Counter =
    if ( n <= 0) this
    else increase.increase(n-1)

  def decrease(n: Int): Counter =
    if(n <= 0) this
    else decrease.decrease(n+1)

  def print = println(valueInt)

}

//////////////Takeaways///////////////////////////
/*
  Defining classes                   class Person(name: String, age: Int)
  Instantiating                      val bob = new Person("Bob", 24)
  Parameters vs fields               class Person(val name: String, age: Int)
  Defining methods                   def greet(): String = {....}
  Calling methods                    val bobSayHi = bob.greet
  The keyword this
 */