package com.group.solution.domain.service

import com.group.solution.domain.service.factory.UserFactory
import com.group.solution.domain.service.repository.UserRepository
import com.group.solution.exception.ResourceNotFoundException
import com.group.solution.model.dto.UserData
import com.group.solution.model.factory.UserFactoryDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class UserService(
    val factory: UserFactory,
    val factoryDto: UserFactoryDto,
    val userRepository: UserRepository
) {

    @Transactional
    fun createUser(userData: UserData): UserData {

        val user = factory.createUser(userData)
        userRepository.save(user)
        val userData = factoryDto.createUserData(user)

        return userData
    }

    fun getAll(): List<UserData> {
        val users = userRepository.findAll()
        if(users.isEmpty()){
            throw ResourceNotFoundException("No users found")
        }
        return users.map { factoryDto.createUserData(it) }
    }

    @Transactional
    fun updateUser(userData: UserData, id: Long): UserData? {
        var user = userRepository.findById(id).orElseThrow {
            throw NoSuchElementException("User not found")
        }
        user = factory.updateUser(user)
        userRepository.save(user)
        return factoryDto.createUserData(user)
    }

    fun deleteUser(id: Long) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        } else {
            throw NoSuchElementException("User not found")
        }
    }
}
