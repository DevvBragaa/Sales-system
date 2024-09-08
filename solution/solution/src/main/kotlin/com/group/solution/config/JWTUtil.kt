package com.group.solution.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Component
class JWTUtil {

    @Value("\${spring.jwt.secret}")
    private lateinit var secret: String

    private lateinit var key: Key

    @PostConstruct
    fun init() {
        key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
    }

    fun generateToken(username: String): String? {
        val expiration = 360000
        return Jwts
            .builder()
            .expiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }
}
