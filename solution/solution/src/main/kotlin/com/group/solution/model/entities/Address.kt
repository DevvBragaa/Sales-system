package com.group.solution.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "street", nullable = false)
    var street: String,

    @Column(name = "city", nullable = false)
    var city: String,

    @Column(name = "state", nullable = false)
    var state: String,

    @Column(name = "country", nullable = false)
    var country: String,

    @Column(name = "postal_code", nullable = false)
    var postalCode: String,
)
