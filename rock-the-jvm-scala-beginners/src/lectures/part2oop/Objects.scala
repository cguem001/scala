package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // The equivalent in scala is: (See Javaplayground.java file)

  // we split the functionality between classes and objects
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method, because it's sole purpose is to build a persons given some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  //Objects can be define in a similar way as Classes, but objects don't take parameters

  class Person(val name: String) {
    //instance-level functionality
  }
  // This pattern of writing classes and objects in the same scope is called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects are singleton instances
  // Scala object = SINGLETON INSTANCE
  val mary = Person //--> This is the instance of the Person type
  val john = Person
  println(mary == john) // it prints true as mary and john point to the same instance, which is object called Person

  val person1 = new Person("Mary")
  val person2 = new Person("John")
  /*
  when we said this is a singleton object object Person{} I mean that there is a single instance
  that can be referred to with the name person
   */

  val bobbie = Person(person1, person2)

  // Scala Applications = scala object with very particular method
  // def main(args: Array[String]): Unit
}

///////////TAKE AWAYS////////////
/*
Scala doesn't have "static" values/methods

it has Scala objects
  - are in their own class
  - are the only instance
  - singleton pattern in one line

Scala companions
  - can access each other's private members
  - Scala in more OO than Java!

Scala applications
  - def main(args: Array[String]): Unit
  - object MyApp extends App


 */
