package edu
import org.apache.log4j.Logger

class Operations {
  val randomGenerator = scala.util.Random
  val randomLimiter: Int = 6
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
          diceGame(randomGenerator.nextInt(randomLimiter) + 1,counter-1)
        }
      }
    }
    if(diceGame(randomGenerator.nextInt(randomLimiter) + 1,limit)){
      "You win \n"
    }
    else {
      "You lose \n"
    }
  }

  def takeAttendance(): Int ={
    val classStrength = 50
    randomGenerator.nextInt(classStrength) + 1
  }

  def favouriteSubjectFinder(mainSubjectBlog: Map[String,Int],originalSubjectDomain: List[String]): String = {
    val attempts: Int = 5
    def favouriteSubjectCalculator(subjectBlog: Map[String,Int],counter: Int): Map[String,Int] = {
      val subject = originalSubjectDomain(randomGenerator.nextInt(randomLimiter))
      val subjectCount = subjectBlog get subject
      val tempMap = subjectBlog + (subject -> (subjectCount.get + 1))
      if(counter>0){
        favouriteSubjectCalculator(tempMap,counter-1 )
      }
      else {
        tempMap
      }
    }
    val finalMap = favouriteSubjectCalculator(mainSubjectBlog,attempts)
    val favouriteSubject = finalMap.maxBy(_._2) //ask this logic
    favouriteSubject._1
  }

}
