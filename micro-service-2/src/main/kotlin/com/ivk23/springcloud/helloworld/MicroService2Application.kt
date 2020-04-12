package com.ivk23.springcloud.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
class MicroService2Application

fun main(args: Array<String>) {
    runApplication<MicroService2Application>(*args)
}
