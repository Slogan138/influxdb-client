package io.slogan.influxdb.client.config

import com.influxdb.client.InfluxDBClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InfluxConfiguration {

    @Bean
    fun influxDBClient() = InfluxDBClientFactory.create()
}