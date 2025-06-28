package config

import com.typesafe.config.ConfigFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ConfigSpec extends AnyFlatSpec with Matchers {

  "Configuration" should "load test environment config" in {
    val config = ConfigFactory.load()
    val env = config.getString("env")

    env shouldBe "test"
  }
}
