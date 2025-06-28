error id: file://<WORKSPACE>/lab6_unit/src/test/scala/9_AsyncServiceSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/9_AsyncServiceSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 264
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/9_AsyncServiceSpec.scala
text:
```scala
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class AsyncServiceSpec extends AsyncFlatSpec with Matchers:

  "AsyncService" should "handle futures" in {
    val future = AsyncService.processData("test")
    future.map(_@@ should be("processed: test"))
  }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.