package com.group.solution.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseBody
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<String> {
        // Retorna um status 404 com uma mensagem de erro
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}