package com.example.helloservice.entity

import com.example.helloservice.model.HelloResponse
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "hello_record", schema = "hello_service")
class HelloRecord(
    @Id
    var id: String = UUID.randomUUID().toString(),
    var message: String = ""
) {

    fun toResponse() = HelloResponse(
        id = this.id,
        message = this.message
    )
}
