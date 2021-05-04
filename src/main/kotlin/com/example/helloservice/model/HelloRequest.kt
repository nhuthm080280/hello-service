package com.example.helloservice.model

import com.example.helloservice.entity.HelloRecord

data class HelloRequest(
    val message: String = ""
) {
    fun toEntity() = HelloRecord(
        message = this.message
    )
}

