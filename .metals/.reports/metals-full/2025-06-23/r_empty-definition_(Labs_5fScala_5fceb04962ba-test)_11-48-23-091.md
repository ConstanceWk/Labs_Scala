error id: file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/CollectionUtilsSpec.scala:`<none>`.
file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/CollectionUtilsSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -CollectionUtils.
	 -scala/Predef.CollectionUtils.
offset: 797
uri: file://<WORKSPACE>/Lab5_new/scala_test/src/test/scala/CollectionUtilsSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CollectionUtilsSpec extends AnyFlatSpec with Matchers {
  
  // ========================================================================
  // Tests pour findMax
  // ========================================================================
  
  "CollectionUtils" should "find maximum value in non-empty list" in {
    CollectionUtils.findMax(List(1, 5, 3, 9, 2)) shouldBe Some(9)
    CollectionUtils.findMax(List(10)) shouldBe Some(10)
    CollectionUtils.findMax(List(-5, -1, -10)) shouldBe Some(-1)
    CollectionUtils.findMax(List(0, -1, 1)) shouldBe Some(1)
  }
  
  it should "return None for empty list in findMax" in {
    CollectionUtils.findMax(List.empty[Int]) shouldBe None
    CollectionUtil@@s.findMax(List()) shouldBe None
  }
  
  it should "handle duplicate maximum values" in {
    CollectionUtils.findMax(List(5, 5, 5)) shouldBe Some(5)
    CollectionUtils.findMax(List(1, 3, 3, 2)) shouldBe Some(3)
  }
  
  it should "work with large lists" in {
    val largeList = (1 to 1000).toList
    CollectionUtils.findMax(largeList) shouldBe Some(1000)
  }
  
  // ========================================================================
  // Tests pour filterEven
  // ========================================================================
  
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
  
  // ========================================================================
  // Tests pour groupByLength
  // ========================================================================
  
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
  
  // ========================================================================
  // Tests pour les versions génériques (bonus)
  // ========================================================================
  
  it should "work with different collection types" in {
    // Test avec Vector
    CollectionUtils.findMaxGeneric(Vector(1, 5, 3)) shouldBe Some(5)
    CollectionUtils.findMaxGeneric(Vector.empty[Int]) shouldBe None
    
    // Test avec Set
    CollectionUtils.findMaxGeneric(Set(3, 1, 4, 1, 5)) shouldBe Some(5)
    
    // Test avec Seq
    CollectionUtils.filterEvenSeq(Seq(1, 2, 3, 4)) should contain theSameElementsAs Seq(2, 4)
  }
  
  it should "work with strings in findMaxGeneric" in {
    CollectionUtils.findMaxGeneric(List("apple", "banana", "cherry")) shouldBe Some("cherry")
    CollectionUtils.findMaxGeneric(List("a", "aa", "aaa")) shouldBe Some("aaa")
  }
  
  // ========================================================================
  // Tests de performance et edge cases
  // ========================================================================
  
  it should "handle very large collections efficiently" in {
    val largeList = (1 to 100000).toList
    val evenNumbers = CollectionUtils.filterEven(largeList)
    evenNumbers should have size 50000
    evenNumbers.head shouldBe 2
    evenNumbers.last shouldBe 100000
  }
  
  it should "handle collections with duplicate elements" in {
    val duplicates = List(1, 1, 2, 2, 3, 3)
    CollectionUtils.findMax(duplicates) shouldBe Some(3)
    CollectionUtils.filterEven(duplicates) should contain theSameElementsAs List(2, 2)
    
    val stringDuplicates = List("aa", "bb", "aa", "cc")
    val grouped = CollectionUtils.groupByLength(stringDuplicates)
    grouped(2) should contain theSameElementsAs List("aa", "bb", "aa", "cc")
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.