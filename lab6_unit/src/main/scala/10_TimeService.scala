import java.time.{Clock, LocalDate, ZoneId}

class TimeService(clock: Clock):
  def currentDate(): LocalDate =
    LocalDate.now(clock)
