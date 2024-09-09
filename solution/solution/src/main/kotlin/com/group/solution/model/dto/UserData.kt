package com.group.solution.model.dto

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

    @field:NotBlank
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
    val postalCode: String,
)
