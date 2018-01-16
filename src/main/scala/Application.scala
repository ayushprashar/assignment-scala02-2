import edu._
import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val perform = new Operations
  val billAmount: Int = 1000
  val payTM = PayTM(billAmount)
  val cash = Cash(billAmount)
  val freeCharge = FreeCharge(billAmount)
  val netBanking = NetBanking(billAmount)
  val cardPayment = CardPayment(billAmount)

 /* log.info(s"The final amount for PayTM user is ${perform.calculateBill(payTM)}\n")
  log.info(s"The final amount for Cash paying user is ${perform.calculateBill(cash)}\n")
  log.info(s"The final amount for FreeCharge user is ${perform.calculateBill(freeCharge)} \n")
  log.info(s"The final amount for NetBanking user is ${perform.calculateBill(netBanking)} \n")
  log.info(s"The final amount for Card user is ${perform.calculateBill(cardPayment)} \n")
 */
  log.info(perform.mainDice())
}
