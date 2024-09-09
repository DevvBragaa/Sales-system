package com.group.solution.model.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "TB_USERS")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    val id: Long? = null,

    @Column(name = "USER_NAME", nullable = false)
    var name: String,

    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    var email: String,

    @Column(name = "USER_PASSWORD", nullable = false)
    var password: String,

    @Column(name = "USER_CNPJ", nullable = false, unique = true)
    var cnpj: String,

    @Column(name = "USER_OCCUPATION", nullable = false)
    var occupation: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
    var address: Address? = null,

    @JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(name = "USER_ROLE",
        joinColumns = [JoinColumn(name = "usuario_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val role: List<Role> = mutableListOf()
)
