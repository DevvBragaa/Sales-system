package com.group.solution.controller

import com.group.solution.domain.service.UserService
import com.group.solution.domain.service.repository.UserRepository
import com.group.solution.model.dto.Credentials
import com.group.solution.model.dto.UserData
import com.group.solution.security.JWTUtil
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/login")
class AuthController (
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JWTUtil
) {

    @PostMapping
    fun loginRequest(@RequestBody @Valid credentials: Credentials): ResponseEntity<Any> {
        try {
            // Criação do objeto de autenticação com as credenciais fornecidas
            val usernamePasswordAuthToken = UsernamePasswordAuthenticationToken(
                credentials.username, credentials.password
            )

            // Autenticação via AuthenticationManager
            val auth: Authentication = authenticationManager.authenticate(usernamePasswordAuthToken)

            // Se a autenticação for bem-sucedida, o token JWT é gerado
            SecurityContextHolder.getContext().authentication = auth
            val user = auth.principal as org.springframework.security.core.userdetails.User
            val token = jwtUtil.generateToken(user.username, user.authorities)

            // Retorna o token JWT no corpo da resposta
            return ResponseEntity.ok("Bearer $token")
        } catch (e: Exception) {
            return ResponseEntity.status(401).body("Login failed: ${e.message}")
        }
    }

    @PostMapping("/register")
    fun create(
        @RequestBody @Valid userData: UserData,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<String> {


        val dto = userService.createUser(userData)
        val uri = uriComponentsBuilder.path("/users").buildAndExpand(dto.id).toUri()
        return ResponseEntity.created(uri).body("Registration completed successfully!!")
    }

}