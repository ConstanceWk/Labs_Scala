object CollectionUtils:

  def findMax(numbers: List[Int]): Option[Int] =
    if numbers.isEmpty then None else Some(numbers.max)

  def filterEven(numbers: List[Int]): List[Int] =
    numbers.filter(_ % 2 == 0)

  def groupByLength(words: List[String]): Map[Int, List[String]] =
    words.groupBy(_.length)
