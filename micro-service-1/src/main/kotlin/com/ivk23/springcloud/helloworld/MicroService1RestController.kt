package com.ivk23.springcloud.helloworld

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MicroService1RestController {

    @Value("\${spring.profiles.active}")
    private lateinit var activeProfile: String

    @Autowired
    private lateinit var feignClient: MicroService2FeignClient

    @HystrixCommand(fallbackMethod = "getMsgFallback")
    @GetMapping
    fun getMsg(): Any {
        // here we actually call another service
        val msgFromService2 = feignClient.getMessage()
        return object {
            val me = "micro-service-1.$activeProfile"
            val did = "called micro-service-2"
            val got = msgFromService2
        }
    }

    fun getMsgFallback(): Any {
        return object {
            val me = "micro-service-1.$activeProfile"
            val did = "called micro-service-2 but failed"
            val got = "nothing. perhaps micro-service-2 is not available"
        }
    }

    @PostMapping(consumes = [TEXT_PLAIN_VALUE])
    fun postMsg(@RequestBody msg: String): Any {
        return object {
            val from = "micro-service-1.$activeProfile"
            val answer = "got your message [$msg]"
        }
    }

}