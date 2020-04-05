package com.ivk23.springcloud.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloWorldAppApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldAppApplication>(*args)
}
