import java.nio.file.{Files, Path}

object FileProcessor:
  def countLines(path: Path): Int =
    Files.readAllLines(path).size()
