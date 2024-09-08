package com.group.solution.model.entities

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "TB_ROLE")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    val id: Long? = null,

    @Column(name = "ROLE_NAME")
    private val roleName:String
): GrantedAuthority {
    override fun getAuthority(): String {
        return roleName
    }
}
