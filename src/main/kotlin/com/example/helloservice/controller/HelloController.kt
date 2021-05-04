package com.example.helloservice.controller

import com.example.helloservice.HelloService
import com.example.helloservice.model.HelloRequest
import com.example.helloservice.model.HelloResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hello")
class HelloController(
    private val helloService: HelloService
) {
    @GetMapping("/{id}")
    fun getHelloById(@PathVariable id: String): ResponseEntity<HelloResponse> {
        return ResponseEntity.ok(helloService.getHelloRecordById(id))
    }

    @GetMapping("/")
    fun getListHello(): ResponseEntity<List<HelloResponse>> = ResponseEntity.ok(helloService.getListHello())

    @PostMapping("/")
    fun create(@RequestBody request: HelloRequest): ResponseEntity<HelloResponse> = ResponseEntity.ok(helloService.create(request))

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody helloRequest: HelloRequest): ResponseEntity<HelloResponse> {
        return ResponseEntity.ok(helloService.update(id, helloRequest))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String, @RequestBody helloRequest: HelloRequest) {
        return helloService.delete(id)
    }
}
