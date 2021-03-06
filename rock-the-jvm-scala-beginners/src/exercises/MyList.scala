package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {

  /*
  abstract class which describes a list of integers, implement your own collection
    head = first element of the list (will return an int)
    tail = remainder of the list (will return the last)
    isEmpty = is this list empty (returns a boolean)
    add(int) => new list with this element added
    toString => a string representation of the list print element
    It is possible to use different classes or sub-classes
   */

  val myList: List[Int] = List(1,4,6,8,6,5)

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[ B >:A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing] (element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons[A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
//  val list = new Cons(1, Empty)
//  println(list.head)
////  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(4).head) // when you add an element is added to the head
//  println(list.isEmpty)
//
//  println(list.toString)
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}

/*
SCALA OFFERS CLASS-BASED INHERITANCE
  - access modifiers: private, protected, default(none = public)
  - need to pass in constructor arguments to parent class

DERIVED CLASSES CAN override MEMBERS OR METHODS

REUSE PARENT FIELDS/METHODS WITH super

PREVENT INHERITANCE WITH final AND sealed

abstract classes
traits
Inheriting from a class and multiple traits
*/