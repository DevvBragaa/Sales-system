package com.group.solution.model.dto

import com.group.solution.model.enums.EnumRole
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserData(

    val id: Long? = null,  // Optional for creating new users, required for updating existing ones.  // Optional for creating new users, required for updating existing ones.
    @field:NotBlank
    val name: String,

    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank @field:Size(min = 14, max = 14 ,message = "The CNPJ must have 14 digits")
    val cnpj: String,

    @field:NotBlank
    val occupation: String,

    @field:NotBlank
    val street: String,

    @field:NotBlank
    val city: String,

    @field:NotBlank
    val state: String,

    @field:NotBlank
    val country: String,

    @field:NotBlank
    @field:Size(min = 8 , max = 8, message = "The postal code must have 8 digits")
    val postalCode: String,
)
