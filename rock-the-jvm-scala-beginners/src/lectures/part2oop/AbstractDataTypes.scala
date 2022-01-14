package lectures.part2oop

object AbstractDataTypes extends App {
  // classes which contain unimplemented or abstract fields or methods are called abstract classes
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    // You can omit the word override and the compiler will work as well
    def eat: Unit = println("crunch crunch")
  }

  // traits: they're abstract data types and they're created by using the keyword trait and the name of the abstract class
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "crocodile"

    override def eat: Unit = println("nomnom")

    def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)
}

// Abstract and traits classes can have abstract and non-abstract types
/*
    abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
    }

   trait Carnivore {
   def eat(animal: Animal): Unit
   val preferredMeal: String = "fresh meat"
   }
 */
// Differences between abstract and traits class
// 1 - traits do not have constructor parameters
// 2 - Multiple traits may be inherited by the same class
// 3 - traits is used when it describes a type of behaviour and abstract class is a type of thing
/*
traits = behaviour
abstract = "thing"

abstract class Animal describes animals but trait carnivore describes what they do
so Animal describes animal ("thing") and Crocodile describes what it does
 */