package io.slogan.influxdb.client

import com.influxdb.client.InfluxDBClient
import com.influxdb.client.domain.WritePrecision
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.slogan.influxdb.client.measurement.Metric
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest(
    classes = [InfluxdbClientApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class WriteTests(val influxDBClient: InfluxDBClient) : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        this.describe("Write some data in influxDB2") {
            val range = (1..100)
            val metrics = arrayListOf<Metric>()
            for (i in 1..10) {
                metrics.add(Metric(id = UUID.randomUUID().toString(), value = range.random()))
            }
            influxDBClient.makeWriteApi().use {
                it.writeMeasurements(WritePrecision.S, metrics)
            }
        }
    }
}