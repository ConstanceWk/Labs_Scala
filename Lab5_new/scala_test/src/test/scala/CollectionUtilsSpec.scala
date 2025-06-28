import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CollectionUtilsSpec extends AnyFlatSpec with Matchers {
  
  // Tests pour findMax
  
  "CollectionUtils" should "find maximum value in non-empty list" in {
    CollectionUtils.findMax(List(1, 5, 3, 9, 2)) shouldBe Some(9)
    CollectionUtils.findMax(List(10)) shouldBe Some(10)
    CollectionUtils.findMax(List(-5, -1, -10)) shouldBe Some(-1)
    CollectionUtils.findMax(List(0, -1, 1)) shouldBe Some(1)
  }
  
  it should "return None for empty list in findMax" in {
    CollectionUtils.findMax(List.empty[Int]) shouldBe None
    CollectionUtils.findMax(List()) shouldBe None
  }
  
  it should "handle duplicate maximum values" in {
    CollectionUtils.findMax(List(5, 5, 5)) shouldBe Some(5)
    CollectionUtils.findMax(List(1, 3, 3, 2)) shouldBe Some(3)
  }
  
  it should "work with large lists" in {
    val largeList = (1 to 1000).toList
    CollectionUtils.findMax(largeList) shouldBe Some(1000)
  }
  
  // Tests pour filterEven
  
  it should "filter even numbers correctly" in {
    CollectionUtils.filterEven(List(1, 2, 3, 4, 5, 6)) should contain theSameElementsAs List(2, 4, 6)
    CollectionUtils.filterEven(List(2, 4, 6, 8)) should contain theSameElementsAs List(2, 4, 6, 8)
    CollectionUtils.filterEven(List(1, 3, 5, 7)) shouldBe empty
  }
  
  it should "return empty list when filtering even numbers from empty list" in {
    CollectionUtils.filterEven(List.empty[Int]) shouldBe empty
    CollectionUtils.filterEven(List()) should have length 0
  }
  
  it should "handle zero correctly in filterEven" in {
    CollectionUtils.filterEven(List(0, 1, 2)) should contain theSameElementsAs List(0, 2)
    CollectionUtils.filterEven(List(-2, -1, 0, 1, 2)) should contain theSameElementsAs List(-2, 0, 2)
  }
  
  it should "preserve order in filterEven" in {
    CollectionUtils.filterEven(List(2, 1, 4, 3, 6, 5)) should contain theSameElementsInOrderAs List(2, 4, 6)
  }
  
  it should "handle negative even numbers" in {
    CollectionUtils.filterEven(List(-4, -3, -2, -1, 0, 1, 2)) should contain theSameElementsAs List(-4, -2, 0, 2)
  }
  
  // Tests pour groupByLength
  
  it should "group strings by length correctly" in {
    val input = List("a", "bb", "ccc", "dd", "e")
    val result = CollectionUtils.groupByLength(input)
    
    result should have size 3
    result should contain key 1
    result should contain key 2
    result should contain key 3
    
    result(1) should contain theSameElementsAs List("a", "e")
    result(2) should contain theSameElementsAs List("bb", "dd")
    result(3) should contain theSameElementsAs List("ccc")
  }
  
  it should "return empty map for empty string list" in {
    CollectionUtils.groupByLength(List.empty[String]) shouldBe empty
    CollectionUtils.groupByLength(List()) should have size 0
  }
  
  it should "handle empty strings in groupByLength" in {
    val input = List("", "a", "", "bb")
    val result = CollectionUtils.groupByLength(input)
    
    result should contain key 0
    result should contain key 1
    result should contain key 2
    
    result(0) should contain theSameElementsAs List("", "")
    result(1) should contain theSameElementsAs List("a")
    result(2) should contain theSameElementsAs List("bb")
  }
  
  it should "handle all strings of same length" in {
    val input = List("abc", "def", "ghi")
    val result = CollectionUtils.groupByLength(input)
    
    result should have size 1
    result should contain key 3
    result(3) should contain theSameElementsAs List("abc", "def", "ghi")
  }
  
  it should "handle single string" in {
    val result = CollectionUtils.groupByLength(List("hello"))
    result should have size 1
    result should contain key 5
    result(5) should contain theSameElementsAs List("hello")
  }
  
  it should "handle strings with special characters and spaces" in {
    val input = List("a b", "c!", "12", "")
    val result = CollectionUtils.groupByLength(input)
    
    result(0) should contain theSameElementsAs List("")
    result(2) should contain theSameElementsAs List("c!", "12")
    result(3) should contain theSameElementsAs List("a b")
  }
  

  // Tests avec divers datasets
  it should "handle various data sets" in {
    // Large dataset
    val largeList = (1 to 100).toList
    CollectionUtils.findMax(largeList) shouldBe Some(100)
    
    // Mixed positive/negative
    CollectionUtils.filterEven(List(-4, -3, -2, -1, 0, 1, 2, 3, 4)) should contain theSameElementsAs List(-4, -2, 0, 2, 4)
    
    // Strings with special characters
    val specialStrings = List("", "a", "ab", "abc", "!")
    val grouped = CollectionUtils.groupByLength(specialStrings)
    grouped should have size 4
  }
  
}