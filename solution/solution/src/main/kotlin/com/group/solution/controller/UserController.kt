package com.group.solution.controller

import com.group.solution.model.UserData
import com.group.solution.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("User")
class UserController (val userService: UserService) {

    @PostMapping
    fun create(@RequestBody userData: UserData): ResponseEntity<UserData> {

        val dto = userService.createUser(userData);

        return ResponseEntity.ok().body(dto)
    }
}