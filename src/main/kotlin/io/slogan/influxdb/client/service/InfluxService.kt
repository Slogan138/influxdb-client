package io.slogan.influxdb.client.service

import com.influxdb.client.InfluxDBClient
import com.influxdb.client.WriteApi
import com.influxdb.client.domain.WritePrecision
import com.influxdb.query.FluxTable
import com.influxdb.query.dsl.Flux
import com.influxdb.query.dsl.functions.restriction.Restrictions
import io.slogan.influxdb.client.measurement.Metric
import io.slogan.influxdb.client.property.InfluxProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Service
import java.time.Instant

@Service
@EnableConfigurationProperties(InfluxProperties::class)
class InfluxService(
    val influxDBClient: InfluxDBClient,
    val writeApi: WriteApi,
    val influxProperties: InfluxProperties
) {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    fun get(id: String, start: Long, end: Long): List<FluxTable> {
        val startTimeStamp = Instant.ofEpochSecond(start)
        val stopTimeStamp = Instant.ofEpochSecond(start)

        val flux = Flux.from(influxProperties.bucket).range(startTimeStamp, stopTimeStamp).filter(
            Restrictions.and(
                Restrictions.measurement().equal("metric"), Restrictions.column("id").equal(id)
            )
        )
        log.debug(flux.toString())

        return influxDBClient.queryApi.query(flux.toString())
    }

    fun write(id: String, value: Int) {
        val metric = Metric(id, value)
        writeApi.writeMeasurement(WritePrecision.MS, metric)
    }
}