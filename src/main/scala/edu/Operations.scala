package edu
import org.apache.log4j.Logger

class Operations {
  val randomGenerator = scala.util.Random
  val log = Logger.getLogger(this.getClass)

  def calculateBill(paymentMethod: Payment): String = {
    paymentMethod match {
      case PayTM(originalBill) => s"Final bill is ${originalBill * 1.02}"
      case FreeCharge(originalBill) => s"Final bill is ${originalBill * 1.02}"
      case NetBanking(originalBill) => s"Final bill is ${originalBill + 5}"
      case CardPayment(originalBill) => s"Final bill is ${originalBill + 1.5}"
      case Cash(originalBill) => s"Final bill is $originalBill"
    }
  }

  def mainDice(): String = {
    val diceNumber: Int = 6
    val limit = 3

    def diceGame(value: Int,counter: Int): Boolean = {
      if(counter == 0){
        true
      }
      else{
        if(value != 1 && value != 6){
          log.info(s"You got $value \n")//print(value)
          false
        }
        else {
          log.info(s"You got $value \n")//print(value)
          diceGame(randomGenerator.nextInt(diceNumber) + 1,counter-1)
        }
      }
    }
    if(diceGame(randomGenerator.nextInt(diceNumber) + 1,limit)){
      "You win \n"
    }
    else {
      "You lose \n"
    }
  }

  def takeAttendance(): Int ={
    randomGenerator.nextInt(50)+1
  }

  def
}
