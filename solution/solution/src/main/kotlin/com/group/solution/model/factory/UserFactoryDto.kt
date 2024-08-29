package com.group.solution.model.factory

import com.group.solution.model.dto.UserData
import com.group.solution.model.entities.User
import org.springframework.stereotype.Component

@Component
class UserFactoryDto {

    fun createUserData(user: User): UserData {

        return UserData(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password,
            cnpj = user.cnpj,
            occupation = user.occupation,
            street = user.address!!.street,
            city = user.address!!.city,
            state = user.address!!.state,
            country = user.address!!.country,
            postalCode = user.address!!.postalCode)
    }
}