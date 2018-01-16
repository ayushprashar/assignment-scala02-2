val randomGenerator = scala.util.Random
private def randomSubjectGenerator(subjectDomain: List[String]): String = {
  subjectDomain(randomGenerator.nextInt(6))
}
def favouriteSubjectFinder(mainSubjectBlog: Map[String,Int],originalSubjectDomain: List[String]): String = {
  val attempts: Int = 5
  def favouriteSubjectCalculator(subjectBlog: Map[String,Int],counter: Int): Map[String,Int] = {
    val subject = originalSubjectDomain(randomGenerator.nextInt(6))
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
  val favouriteSubject = finalMap.maxBy(_._2)
  favouriteSubject._1
}
val map = Map("scala"->3,"java"->4,"c"->1,"cpp"->2,"node"->2,"js"->2)
val list = List("scala","java","c","cpp","node","js")
favouriteSubjectFinder(map,list)
 //randomSubjectGenerator(list)