package com.ivk23.springcloud.helloworld

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import kotlin.random.Random

@RestController
class HelloWorldController {

    @Value("\${hello.world.username}")
    private lateinit var user: String

    @Value("\${test-prop}")
    private lateinit var testProp: String


    @GetMapping("/hello")
    fun getHello(): String {
        return "Hello, $user. There is also another property available: $testProp !"
    }

    @HystrixCommand(fallbackMethod = "postHelloFallback",
            commandProperties = [
                HystrixProperty(
                        name = "circuitBreaker.requestVolumeThreshold",
                        value = "2")
            ])
    @PostMapping("/hello")
    fun postHello(@RequestBody msg: String): Any {
        // here we do stuff that might fail :)
        // but Hystrix should take care
        val rand = Random.Default.nextInt(5)
        if (rand == 0) {
            throw IllegalStateException("Just random exception.")
        }
        return object {
            val time = LocalDateTime.now()
            val input = msg
            val method = "Original Method Called"
        }
    }

    fun postHelloFallback(msg: String): Any {
        // let's handle our failures here
        return object {
            val message = "Fallback Method Called"
            val input = msg
        }
    }

}