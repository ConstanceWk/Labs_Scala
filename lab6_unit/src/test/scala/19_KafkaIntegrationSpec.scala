package integration

import com.dimafeng.testcontainers.KafkaContainer
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.testcontainers.utility.DockerImageName
import org.apache.kafka.clients.producer._
import org.apache.kafka.clients.consumer._
import java.util.{Properties, UUID}
import scala.jdk.CollectionConverters._

class KafkaIntegrationSpec extends AnyFlatSpec with Matchers {

  "Kafka" should "produce and consume a message" in {
    val container = KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.2.1"))
    container.start() // <-- important de le démarrer avant tout

    val topic = "test-topic"
    val message = "hello-kafka"

    val bootstrap = container.bootstrapServers // <-- à faire après .start()

    // --- Producer setup
    val producerProps = new Properties()
    producerProps.put("bootstrap.servers", bootstrap)
    producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](producerProps)
    producer.send(new ProducerRecord[String, String](topic, "key1", message))
    producer.flush()
    producer.close()

    // --- Consumer setup
    val consumerProps = new Properties()
    consumerProps.put("bootstrap.servers", bootstrap)
    consumerProps.put("group.id", UUID.randomUUID().toString)
    consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    consumerProps.put("auto.offset.reset", "earliest")

    val consumer = new KafkaConsumer[String, String](consumerProps)
    consumer.subscribe(java.util.Collections.singletonList(topic))

    val records = consumer.poll(java.time.Duration.ofSeconds(5))
    val values = records.iterator().asScala.map(_.value()).toList

    values should contain(message)
    consumer.close()
    container.stop()
  }
}
