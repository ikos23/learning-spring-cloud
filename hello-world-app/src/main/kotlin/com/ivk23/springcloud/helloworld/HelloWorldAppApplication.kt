package com.ivk23.springcloud.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
class HelloWorldAppApplication

fun main(args: Array<String>) {
    runApplication<HelloWorldAppApplication>(*args)
}
