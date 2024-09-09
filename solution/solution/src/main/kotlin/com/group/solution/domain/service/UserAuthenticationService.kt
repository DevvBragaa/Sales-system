package com.group.solution.domain.service

import com.group.solution.domain.service.repository.UserRepository
import com.group.solution.model.entities.UserDatail
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserAuthenticationService (
    private val userRepository: UserRepository)
    : UserDetailsService{

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?:throw RuntimeException()
        return UserDatail(user)
    }
}