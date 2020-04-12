package com.ivk23.springcloud.helloworld

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MicroService2RestController {

    @Value("\${spring.profiles.active}")
    private lateinit var activeProfile: String

    @GetMapping
    fun getMsg(): String {
        return "micro-service-2.$activeProfile Hello :)"
    }

    @HystrixCommand(fallbackMethod = "postMsgFallback")
    @PostMapping(consumes = [TEXT_PLAIN_VALUE])
    fun postMsg(@RequestBody msg: String): Any {
        return object {
            val from = "micro-service-2.$activeProfile"
            val answer = "got your message [$msg]"
        }
    }

    fun postMsgFallback(msg: String): Any {
        return "Fallback Method Called. Input=$msg"
    }
}