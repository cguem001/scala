package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Paco", 39) // to instantiate Person class
  println(person.age) // 39
  person.greet("Carlos")
  person.greet()
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
