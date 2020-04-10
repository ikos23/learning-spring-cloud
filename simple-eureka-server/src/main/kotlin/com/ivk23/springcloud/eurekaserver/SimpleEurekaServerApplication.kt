package com.ivk23.springcloud.eurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class SimpleEurekaServerApplication

fun main(args: Array<String>) {
	runApplication<SimpleEurekaServerApplication>(*args)
}
