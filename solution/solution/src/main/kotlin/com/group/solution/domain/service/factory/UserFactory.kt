package com.group.solution.domain.service.factory

import com.group.solution.model.entities.Address
import com.group.solution.model.entities.User
import com.group.solution.model.dto.UserData
import org.springframework.stereotype.Component

@Component
class UserFactory(


) {
    fun createUser(userData: UserData) : User {


        // Primeiro, cria o usuário sem a referência ao endereço
        val user = User(
            name = userData.name,
            email = userData.email,
            password = userData.password,
            cnpj = userData.cnpj,
            occupation = userData.occupation,
            address = null // endereço ainda não criado
        )

        // Em seguida, cria o endereço com a referência ao usuário
        val address = Address(
            id = null,
            street = userData.street,
            city = userData.city,
            state = userData.state,
            country = userData.country,
            postalCode = userData.postalCode,
            user = user // usuário agora está criado
        )

        // Atualiza a referência ao endereço no usuário
        user.address = address
        address.user = user

        return user
    }

    fun updateUser(user: User) : User {
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
                    user = user)
            }
        }
    }
}
