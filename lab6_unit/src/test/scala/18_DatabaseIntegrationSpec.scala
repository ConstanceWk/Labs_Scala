package integration

import com.dimafeng.testcontainers.{ForAllTestContainer, PostgreSQLContainer}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.BeforeAndAfterAll // ✅ à ajouter
import org.testcontainers.utility.DockerImageName

class DatabaseIntegrationSpec
    extends AnyFlatSpec
    with ForAllTestContainer
    with BeforeAndAfterAll { // ✅ pour utiliser beforeAll()

  override val container: PostgreSQLContainer = 
    PostgreSQLContainer(DockerImageName.parse("postgres:13"))

  override def beforeAll(): Unit = {
    super.beforeAll() // ✅ maintenant reconnu
    container.start()
  }

  "PostgreSQL container" should "start and expose JDBC URL" in {
    assert(container.jdbcUrl.startsWith("jdbc:postgresql://"))
  }
}
