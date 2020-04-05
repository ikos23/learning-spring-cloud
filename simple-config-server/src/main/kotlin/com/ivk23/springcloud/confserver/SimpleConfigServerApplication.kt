package com.ivk23.springcloud.confserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class SimpleConfigServerApplication

fun main(args: Array<String>) {
    runApplication<SimpleConfigServerApplication>(*args)
}
