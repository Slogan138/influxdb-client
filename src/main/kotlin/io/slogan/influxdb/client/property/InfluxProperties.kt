package io.slogan.influxdb.client.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "influx")
data class InfluxProperties(val url: String, val org: String, val bucket: String, val token: String)
