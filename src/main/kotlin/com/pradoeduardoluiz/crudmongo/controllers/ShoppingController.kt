package com.pradoeduardoluiz.crudmongo.controllers

import com.pradoeduardoluiz.crudmongo.dto.ResponseDTO
import com.pradoeduardoluiz.crudmongo.dto.ShoppingDTO
import com.pradoeduardoluiz.crudmongo.mappers.toDto
import com.pradoeduardoluiz.crudmongo.mappers.toModel
import com.pradoeduardoluiz.crudmongo.service.ShoppingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ShoppingController(private val service: ShoppingService) {

    @PostMapping("api/shopping")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@Valid @RequestBody shopping: ShoppingDTO): ResponseEntity<ResponseDTO<ShoppingDTO>> {
        val response = persist(shopping)
        return ResponseEntity.ok(ResponseDTO(data = response))
    }

    @GetMapping("api/shopping")
    fun getAll(): ResponseEntity<ResponseDTO<List<ShoppingDTO>>> {
        val response = service.getAll().map {
            it.toDto()
        }
        return ResponseEntity.ok(ResponseDTO(data = response))
    }

    @GetMapping("api/shopping/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<ResponseDTO<ShoppingDTO>> {
        val response = service.findById(id = id)
        response?.let {
            return ResponseEntity.ok(ResponseDTO(data = response.toDto()))
        } ?: run {
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("api/shopping/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        service.deleteById(id = id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("api/shopping")
    fun put(@Valid @RequestBody shopping: ShoppingDTO): ResponseEntity<Unit> {
        val response = persist(shopping)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("api/shopping")
    @ResponseStatus(HttpStatus.OK)
    fun patch(@Valid @RequestBody shopping: ShoppingDTO): ResponseEntity<ResponseDTO<ShoppingDTO>> {
        val response = persist(shopping)
        return ResponseEntity.ok(ResponseDTO(data = response))
    }

    private fun persist(shopping: ShoppingDTO): ShoppingDTO {
        return service.persist(shopping = shopping.toModel()).toDto()
    }
}