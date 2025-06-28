error id: file://<WORKSPACE>/lab6_unit/src/test/scala/3_CollectionUtilsSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/3_CollectionUtilsSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -should.
	 -should#
	 -should().
	 -scala/Predef.should.
	 -scala/Predef.should#
	 -scala/Predef.should().
offset: 892
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/3_CollectionUtilsSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CollectionUtilsSpec extends AnyFlatSpec with Matchers:

  "findMax" should "return the maximum value in a non-empty list" in {
    CollectionUtils.findMax(List(1, 5, 3)) shouldBe Some(5)
  }

  it should "return None for an empty list" in {
    CollectionUtils.findMax(List()) shouldBe None
  }

  "filterEven" should "return even numbers from a list" in {
    CollectionUtils.filterEven(List(1, 2, 3, 4)) should contain theSameElementsAs List(2, 4)
  }

  it should "return empty list if there are no even numbers" in {
    CollectionUtils.filterEven(List(1, 3, 5)) shouldBe empty
  }

  "groupByLength" should "group strings by their length" in {
    val input = List("hi", "you", "to", "a")
    val result = CollectionUtils.groupByLength(input)
    result(1) should contain ("a")
    result(2) @@should contain ("hi", "to")
    result(3) should contain ("you")
  }

  it should "return an empty map when input is empty" in {
    CollectionUtils.groupByLength(Nil) shouldBe empty
  }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.