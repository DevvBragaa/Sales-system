package com.group.solution.controller

import com.group.solution.domain.service.UserService
import com.group.solution.model.dto.UserData
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun getAll(): ResponseEntity<Any> {
        val userDataList = userService.getAll()
        return ResponseEntity.ok().body(userDataList)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid userData: UserData,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<String> {


        val dto = userService.createUser(userData)
        val uri = uriComponentsBuilder.path("/users").buildAndExpand(dto.id).toUri()
        return ResponseEntity.created(uri).body("Registration completed successfully!!")
    }

    @PutMapping("{id}")
    fun update(@RequestBody userData: UserData, @PathVariable id: Long): ResponseEntity<UserData> {
        val updatedUser = userService.updateUser(userData, id);
        return ResponseEntity.ok().body(updatedUser)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build()
    }
}
