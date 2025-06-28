error id: file://<WORKSPACE>/lab6_unit/src/test/scala/20_ConfigSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/20_ConfigSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 402
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/20_ConfigSpec.scala
text:
```scala
package config

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.typesafe.config.ConfigFactory

class ConfigSpec extends AnyFlatSpec with Matchers {

  val config = ConfigFactory.load()

  "Configuration" should "load test environment config" in {
    config.getString("env") shouldEqual "test"
    config.getString("db.url") should startWith("jdbc:h2:@@mem")
    config.getString("db.user") shouldEqual "test-user"
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.