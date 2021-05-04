package com.example.helloservice.repository

import com.example.helloservice.entity.HelloRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloRecordRepository : JpaRepository<HelloRecord, String> {
    fun getHelloRecordById(id: String): HelloRecord
}
