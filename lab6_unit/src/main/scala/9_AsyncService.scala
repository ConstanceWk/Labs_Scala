import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object AsyncService:
  def processData(input: String): Future[String] =
    Future {
      s"processed: $input"
    }
