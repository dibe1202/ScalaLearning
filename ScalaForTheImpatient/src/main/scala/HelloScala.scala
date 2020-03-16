import scala.io.Source

/**
 * @ project:  Scalalearning
 * @ package:  
 * @ author:   whn
 * @ date:     2020-2-24 10:10
 * @ Function:    
 */
object HelloScala {
  def main(args: Array[String]): Unit = {

    val ax = 1

    val res1 = if(ax > 1) {
      val res2 = ax + 2
      res2
    }

    val res2: Any = if(ax>1) 1 else "2"
    val res3: AnyVal = if(ax>1) 1 // else ()


//    println("Scala Scala Scala")
    val arr = Array(1, 2)

    /**
     * wordCount
     */
    val data = Source.fromFile("E:\\ideaProjects\\Scalalearning\\ScalaForTheImpatient\\wd.txt")
    val res = data
      .getLines()
      .flatMap((xs: String) => xs.trim.split(" "))
      .toArray
      .map(word => (word,1))
      .groupBy((xs: (String, Int)) => xs._1 )
      .map(tuple => (tuple._1,tuple._2.length))
      .toArray
      .sortBy((xs: (String, Int)) => -xs._2)
//        .foreach(arr => println(arr.mkString(",")))
      .foreach(println)
  }
}
