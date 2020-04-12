package com.ivk23.springcloud.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@SpringBootApplication
class MicroService1Application

fun main(args: Array<String>) {
    runApplication<MicroService1Application>(*args)
}
