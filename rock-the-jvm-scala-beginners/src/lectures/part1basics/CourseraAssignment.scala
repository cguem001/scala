package lectures.part1basics

object CourseraAssignment extends App {

//  def balance(chars: List [Char]): Boolean = {
//    var actual = chars.head
//    def balance(chars: List[Char], accumulator: Int): Boolean = {
//      if (chars.isEmpty) accumulator == 0
//      else if (chars.head == ')') {balance(chars.tail, accumulator -1) && accumulator > 0}
//      else if (chars.head == '(') {balance(chars.tail, accumulator + 1)}
//      else balance(chars.tail, accumulator)
//    }
//    balance(chars, 0)
//  }
//
//    println(balance("())(".toList))

  def countChange(money: Int, coins: List[Int]): Int = {
    def countChange(money: Int, coins: List[Int], accumulator: Int): Int = {
      if (money < 0) accumulator
      else
        if (coins.isEmpty)
          if (money == 0) accumulator + 1 else accumulator
        else countChange(money, coins.tail, accumulator) +
          countChange(money - coins.head, coins, accumulator)
    }
    countChange(money, coins, 0)
  }

  var a = List(1,2)

  println(countChange(4, a))

//  println(14 % 7)

}
