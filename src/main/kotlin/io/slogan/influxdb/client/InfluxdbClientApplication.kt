package io.slogan.influxdb.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InfluxdbClientApplication

fun main(args: Array<String>) {
    runApplication<InfluxdbClientApplication>(*args)
}
