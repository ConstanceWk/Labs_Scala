import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.time.{Clock, Instant, LocalDate, ZoneId}

class TimeServiceSpec extends AnyFlatSpec with Matchers:

  "TimeService" should "return fixed current date when using fixed clock" in {
    val fixedInstant = Instant.parse("2025-06-27T00:00:00Z")
    val fixedClock = Clock.fixed(fixedInstant, ZoneId.of("UTC"))

    val timeService = TimeService(fixedClock)
    val today = timeService.currentDate()

    today should be (LocalDate.of(2025, 6, 27))
  }
