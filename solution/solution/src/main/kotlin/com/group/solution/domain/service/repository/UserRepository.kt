package com.group.solution.domain.service.repository

import com.group.solution.model.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, Long> {
}