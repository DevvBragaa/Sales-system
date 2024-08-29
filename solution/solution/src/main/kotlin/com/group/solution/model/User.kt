package com.group.solution.model

import jakarta.persistence.*


@Entity
@Table(name = "tb_users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "cpf", nullable = false, unique = true)
    val cnpj: String,

    @Column(name = "occupation", nullable = false)
    val occupation: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address
)

