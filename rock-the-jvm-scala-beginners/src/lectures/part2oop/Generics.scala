package lectures.part2oop

object Generics extends App{

  class MyList[+A] { // this is call a generic class with a type parameter A
    //use the type A inside the class definition
//    def add(element: A): MyList[A] = ??? this is throwing an error
    // to fix it
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Animal
     */
  }

  // this also works for traits
  trait MyTraitList[A] {
  }

  class MyMap[key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
   If cat extends animal, does a list of cat also extend the list of animal?
   There are three possible answers to this question
   1 - Yes, List[Cat] extends List[Animal] = COVARIANCE
   2 - No, List[Cat] and List[Animal] are two different things
   3 - No
  */

  // 1 Yes
  class CovarianceList[+A]
  val animal: Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2 No = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // Bounded types allow you to use your generic classes only for certain types that are either a subclass
  // of a different type or a super class of a different type
  class Cage[A <: Animal] (animal: A) // this means class Cage only accepts type parameters A which are subtypes of Animal
  val cage = new Cage(new Dog)

  class Car
//  val newCar = new Cage(new Car) this will throw an error as it infrared type of arguments, that's because
  // car is not a type of animal
  // Will get an error because a new car does not conform to the expected type

  // expand MyList to be generic



}

/*
TAKEAWAYS
Use the same code on many (potentially unrelated) types:
trait List[t] {
  def add(elem: T)
}

Generic methods
object List {
  def single[A](element: A): List[A] = ???
}

Multiple type parameters
trait Map[Key, Value] {
  ...
}

Variant: if B extends A, should List[B] extend List[A]?
    trait List[+A] yes(covariant)
    trait List[A] no(invariant) - default
    trait List[-A] hell no! (contravariant)

Bounded types
class Car
class Supercar extends Car
class Garage[T <: Car](car: T)
 */
