object CollectionUtils {
  
  def findMax(numbers: List[Int]): Option[Int] = {
    if (numbers.isEmpty) None
    else Some(numbers.max)
  }
  
  def filterEven(numbers: List[Int]): List[Int] = {
    numbers.filter(_ % 2 == 0)
  }
  
  def groupByLength(strings: List[String]): Map[Int, List[String]] = {
    strings.groupBy(_.length)
  }
  
  def findMaxGeneric[T](collection: Iterable[T])(implicit ord: Ordering[T]): Option[T] = {
    if (collection.isEmpty) None
    else Some(collection.max)
  }
  
  def filterEvenSeq(numbers: Seq[Int]): Seq[Int] = {
    numbers.filter(_ % 2 == 0)
  }
}