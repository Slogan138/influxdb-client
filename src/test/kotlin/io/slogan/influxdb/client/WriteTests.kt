package io.slogan.influxdb.client

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.slogan.influxdb.client.measurement.Metric
import io.slogan.influxdb.client.service.InfluxService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest(
    classes = [InfluxdbClientApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class WriteTests(
    val influxService: InfluxService
) : DescribeSpec() {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun extensions() = listOf(SpringExtension)

    init {
        this.describe("Write some data in influxDB2") {
            val range = (1..100)
            val metrics = mutableListOf<Metric>()
            for (i in 1..10) {
                metrics.add(Metric(id = UUID.randomUUID().toString(), value = range.random()))
            }
            log.debug("metrics = $metrics")

            for (metric in metrics) {
                influxService.write(metric)
            }
        }
    }
}