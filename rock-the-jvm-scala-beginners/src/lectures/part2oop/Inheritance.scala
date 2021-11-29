package lectures.part2oop

object Inheritance extends App {

  // Scala offers single class inheritance
  class Animal {
    val creatureType = "Wild"

        def eat = println("nomnom")
//    private def eat = println("nomnom") this method is only accessible in this class only
//    protected def eat = println("nomnom") // this method is only accessible in this class and sub-classes
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

    // constructors
  class Person(name: String, age: Int) {
      def this(name: String) = this(name, 0)
    }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

//   overriding
  class Dog(override val creatureType: String) extends Animal {
  //    override val creatureType = "domestic"
  //    override def eat = println("Crunch, crunch")
  override def eat = {
    super.eat
    println("crunch, crunch")
  }
  }

//  class Dog(dogType: String) extends Animal{
//    override val creatureType = dogType
//  }
  val dog = new Dog("K9")

  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  /*
  Overriding: supplying different implementation in derived classes
  Overloading: supplying multiple methods with different signatures but with the same name in the same class
   */

  // super -> is used when you want to reference a method or a field from parent class

  // preventing overrides
  // 1 - by using the keyword final on member
  /*
  class Animal {
    final def eat  = println("nomnom")
  }
   */
  // 2 - by using final on the entire class
  /*
  final class Animal {
    def eat  = println("nomnom")
  }
   */
  // 3 - by seal the class = extend classes in THIS FILE,
  /*
  sealed class Animal {
    def eat  = println("nomnom")
  }
   */


}
