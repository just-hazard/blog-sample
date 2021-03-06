package com.example.kafkasamplenew

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/kafka")
class KafkaSampleApi(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @PostMapping
    fun simple(@RequestBody simple: Simple) {
        kafkaTemplate.send("yun", simple.email)
    }
}

data class Simple(
    val name: String,
    val email: String
)