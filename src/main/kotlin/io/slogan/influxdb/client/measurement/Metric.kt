package io.slogan.influxdb.client.measurement

import com.influxdb.annotations.Column
import com.influxdb.annotations.Measurement
import java.time.Instant

@Measurement(name = "metric")
data class Metric(
    @Column(tag = true) val id: String,
    @Column val value: Int,
    @Column(timestamp = true) val time: Instant = Instant.now()
)