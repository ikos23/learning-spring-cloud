package com.ivk23.springcloud.helloworld

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @Value("\${hello.world.username}")
    private lateinit var user: String

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, $user"
    }
}