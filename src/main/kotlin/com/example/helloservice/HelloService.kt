package com.example.helloservice

import com.example.helloservice.model.HelloRequest
import com.example.helloservice.model.HelloResponse
import com.example.helloservice.repository.HelloRecordRepository
import org.springframework.stereotype.Service
import java.sql.SQLException
import java.util.*
import java.util.stream.Collectors

@Service
class HelloService(private val helloRecordRepository: HelloRecordRepository) {
    fun getHelloRecordById(id: String): HelloResponse {
        return helloRecordRepository.getHelloRecordById(id).toResponse()
    }

    fun getListHello(): List<HelloResponse> = helloRecordRepository.findAll().stream().map { it.toResponse() }.collect(Collectors.toList())

    fun create(helloRequest: HelloRequest): HelloResponse = helloRecordRepository.save(helloRequest.toEntity()).toResponse()

    fun update(id: String, helloRequest: HelloRequest): HelloResponse {
        if (!helloRecordRepository.existsById(id)) {
            throw SQLException()
        }
        return helloRecordRepository.getHelloRecordById(id).apply { message = helloRequest.message }.toResponse()
    }

    fun delete(id: String) {
        if (!helloRecordRepository.existsById(id)) {
            throw SQLException()
        }
        return helloRecordRepository.delete(helloRecordRepository.getHelloRecordById(id))
    }
}
