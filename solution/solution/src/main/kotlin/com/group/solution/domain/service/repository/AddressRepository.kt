package com.group.solution.domain.service.repository

import com.group.solution.model.entities.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AddressRepository : JpaRepository<Address, Long> {
}