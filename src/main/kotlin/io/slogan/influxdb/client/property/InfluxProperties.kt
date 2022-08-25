package io.slogan.influxdb.client.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "influx")
class InfluxProperties {
    lateinit var url: String
    lateinit var org: String
    lateinit var bucket: String
    lateinit var token: String
}
