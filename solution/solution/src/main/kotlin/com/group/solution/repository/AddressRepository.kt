package com.group.solution.repository

import com.group.solution.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AddressRepository : JpaRepository<Address, Long> {
}