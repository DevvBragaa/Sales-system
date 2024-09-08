package com.group.solution.domain.service.factory

import com.group.solution.model.dto.UserData
import com.group.solution.model.entities.Address
import com.group.solution.model.entities.Role
import com.group.solution.model.entities.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserFactory(


) {
    lateinit var  passwordEncoder: PasswordEncoder

    fun createUser(userData: UserData): User {

        var role:List<Role> = mutableListOf()
        role.plus("USER")
        val address = Address(
            id = null,
            street = userData.street,
            city = userData.city,
            state = userData.state,
            country = userData.country,
            postalCode = userData.postalCode,
        )
        val user = User(
            name = userData.name,
            email = userData.email,
            password = passwordEncoder.encode(userData.password),
            cnpj = userData.cnpj,
            occupation = userData.occupation,
            role = role,
            address = address // endereço ainda não criado
        )
        return user
    }

    fun updateUser(user: User): User {
        return user.apply {
            name = user.name
            email = user.email
            password = user.password
            cnpj = user.cnpj
            occupation = user.occupation
            address = user.address?.let {
                Address(
                    street = user.address!!.street,
                    city = user.address!!.city,
                    state = user.address!!.state,
                    country = user.address!!.country,
                    postalCode = it.postalCode,
                )
            }
        }
    }
}
