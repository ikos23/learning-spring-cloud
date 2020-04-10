package com.ivk23.springcloud.helloworld

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "micro-service-2")
interface MicroService2FeignClient {

    @GetMapping("/messages")
    fun getMessage(): String

    @PostMapping("/messages")
    fun postMessage(): Any

}