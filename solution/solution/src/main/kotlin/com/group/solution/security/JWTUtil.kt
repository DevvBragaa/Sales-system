package com.group.solution.security

import com.group.solution.domain.service.UserAuthenticationService
import com.group.solution.domain.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JWTUtil (
    private val userAuthenticationService: UserAuthenticationService
) {


    @Value("\${spring.jwt.secret}")
    private lateinit var secret: String

    private lateinit var key: SecretKey

    @PostConstruct
    fun init() {
        key = Keys.hmacShaKeyFor(secret.toByteArray())
    }

    private val expiration: Long = 60000

    fun generateToken(username: String, authorities: MutableCollection<out GrantedAuthority>): String {
        return Jwts
            .builder()
            .subject(username)
            .claim("role", authorities)
            .expiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }
    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun getAuthentication(jwt: String?): UsernamePasswordAuthenticationToken {
        val username = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(jwt)
            .payload
            .subject
        val user = userAuthenticationService.loadUserByUsername(username.toString())
        return UsernamePasswordAuthenticationToken(username, null, user.authorities)
    }
}
