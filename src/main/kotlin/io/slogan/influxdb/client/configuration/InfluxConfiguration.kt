package io.slogan.influxdb.client.configuration

import com.influxdb.client.InfluxDBClient
import com.influxdb.client.InfluxDBClientFactory
import com.influxdb.client.WriteApi
import io.slogan.influxdb.client.property.InfluxProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(InfluxProperties::class)
class InfluxConfiguration(
    val influxProperties: InfluxProperties
) {

    @Bean
    fun influxDBClient(): InfluxDBClient {
        return InfluxDBClientFactory.create(
            influxProperties.url, influxProperties.token.toCharArray(), influxProperties.org, influxProperties.bucket
        )
    }

    @Bean
    fun writeApi(influxDBClient: InfluxDBClient): WriteApi {
        return influxDBClient.makeWriteApi()
    }
}