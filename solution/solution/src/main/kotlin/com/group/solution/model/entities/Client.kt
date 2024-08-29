package com.group.solution.model.entities

import jakarta.persistence.*


@Entity
@Table(name = "tb_client")
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "email", nullable = false, unique = true)
    open var email: String? = null
}