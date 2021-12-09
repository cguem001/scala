package exercises

import java.util.NoSuchElementException

abstract class MyList {

  /*
  abstract class which describes a list of integers, implement your own collection
    head = first element of the list (will return an int)
    tail = remainder of the list (will return the last
    isEmpty = is this list empty (returns a boolean)
    add(int) => new list with this element added
    toString => a string representation of the list print element
    It is possible to use different classes or sub-classes
   */

  val myList: List[Int] = List(1,4,6,8,6,5)

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head: Int = throw NoSuchElementException

  override def tail: MyList = throw NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head) // when you add an element is added to the head
  println(list.isEmpty)

  println(list.toString)
}
