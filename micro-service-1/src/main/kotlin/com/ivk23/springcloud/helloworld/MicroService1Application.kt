package com.ivk23.springcloud.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MicroService1Application

fun main(args: Array<String>) {
    runApplication<MicroService1Application>(*args)
}
