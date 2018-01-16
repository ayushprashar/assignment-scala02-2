

def mainDice(): String = {
  val randomGenerator = scala.util.Random
  val diceNumber: Int = 6
  val limit = 3

  def diceGame(value: Int,counter: Int): Boolean = {
    if(counter == 0){
      true
    }
    else{
      if(value != 1 && value != 6){
        print(value)
        false
      }
      else {
        print(value)
        diceGame(randomGenerator.nextInt(diceNumber) + 1,counter-1)
      }
    }

  }
  if(diceGame(randomGenerator.nextInt(diceNumber) + 1,limit)){
    "You are a winner \n"
  }
  else {
    "You are a looser \n"
  }
}
mainDice()






