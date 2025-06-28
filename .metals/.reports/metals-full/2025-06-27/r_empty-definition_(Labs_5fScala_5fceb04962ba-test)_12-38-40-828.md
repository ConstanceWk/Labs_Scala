error id: file://<WORKSPACE>/lab6_unit/src/test/scala/18_DatabaseIntegrationSpec.scala:`<none>`.
file://<WORKSPACE>/lab6_unit/src/test/scala/18_DatabaseIntegrationSpec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 550
uri: file://<WORKSPACE>/lab6_unit/src/test/scala/18_DatabaseIntegrationSpec.scala
text:
```scala
import com.dimafeng.testcontainers.{ForAllTestContainer, PostgreSQLContainer}
import org.scalatest.flatspec.AnyFlatSpec

class DatabaseIntegrationSpec extends AnyFlatSpec with ForAllTestContainer {

  override val container: PostgreSQLContainer = PostgreSQLContainer("postgres:13")

  override def beforeAll(): Unit = {
    super.beforeAll()
    container.start()
  }

  "PostgreSQL container" should "be running" in {
    assert(container.container.isRunning)
  }

  // Tu peux aussi tester la connexion JDBC ici si tu veux :
  it should "provide va@@lid JDBC URL" in {
    val jdbcUrl = container.jdbcUrl
    assert(jdbcUrl.startsWith("jdbc:postgresql://"))
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.