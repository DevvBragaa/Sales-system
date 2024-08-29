package com.group.solution.model.dto

data class UserData(
    val id: Long? = null,  // Optional for creating new users, required for updating existing ones.  // Optional for creating new users, required for updating existing ones.
    val name: String,
    val email: String,
    val password: String,
    val cnpj: String,
    val occupation: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postalCode: String,
)
