package com.group.solution.model.enums


enum class UserRole (private val role:String){

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    fun getRole(): String{
        return role
    }
}
