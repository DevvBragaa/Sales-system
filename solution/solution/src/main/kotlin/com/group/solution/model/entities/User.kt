package com.group.solution.model.entities

import com.group.solution.model.enums.EnumRole
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "tb_users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "user_name", nullable = false)
    var name: String,

    @Column(name = "user_email", nullable = false, unique = true)
    var email: String,

    @Column(name = "user_password", nullable = false)
    var password: String,

    @Column(name = "role", nullable = false)
    var role: EnumRole,

    @Column(name = "user_cnpj", nullable = false, unique = true)
    var cnpj: String,

    @Column(name = "user_occupation", nullable = false)
    var occupation: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var address: Address? = null
)