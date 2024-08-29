package com.group.solution.model.entities

import jakarta.persistence.*


@Entity
@Table(name = "tb_client")
class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "cpf_client", nullable = false)
    val cpf: String,

    @OneToOne
    val address: Address
)