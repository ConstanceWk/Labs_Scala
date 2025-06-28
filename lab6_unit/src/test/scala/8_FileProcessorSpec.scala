import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers

import java.nio.file.{Files, Path}
import java.nio.charset.StandardCharsets

class FileProcessorSpec extends AnyFlatSpec with Matchers with BeforeAndAfterEach:

  var tempFile: Path = _

  override def beforeEach(): Unit =
    tempFile = Files.createTempFile("testfile", ".txt")
    val content =
      """Hello
        |World
        |Scala""".stripMargin
    Files.write(tempFile, content.getBytes(StandardCharsets.UTF_8))

  override def afterEach(): Unit =
    Files.deleteIfExists(tempFile)

  "FileProcessor" should "count the number of lines in a file" in {
    FileProcessor.countLines(tempFile) should be(3)
  }
