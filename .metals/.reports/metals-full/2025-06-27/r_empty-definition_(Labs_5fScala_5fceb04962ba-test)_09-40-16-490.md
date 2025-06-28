error id: file://<WORKSPACE>/lab6_unit/src/test/scala/10_TimeServiceSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/10_TimeServiceSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -java/time/Clock.
	 -Clock.
	 -scala/Predef.Clock.
offset: 363
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/10_TimeServiceSpec.scala
text:
```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.time.{Clock, Instant, LocalDate, ZoneId}

class TimeServiceSpec extends AnyFlatSpec with Matchers:

  "TimeService" should "return fixed current date when using fixed clock" in {
    val fixedInstant = Instant.parse("2025-06-27T00:00:00Z")
    val fixedClock = C@@lock.fixed(fixedInstant, ZoneId.of("UTC"))

    val timeService = TimeService(fixedClock)
    val today = timeService.currentDate()

    today should be (LocalDate.of(2025, 6, 27))
  }

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.