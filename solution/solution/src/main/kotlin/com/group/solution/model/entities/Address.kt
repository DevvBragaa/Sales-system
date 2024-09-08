package com.group.solution.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "TB_ADDRESS")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    val id: Long? = null,

    @Column(name = "STREET", nullable = false)
    var street: String,

    @Column(name = "CITY", nullable = false)
    var city: String,

    @Column(name = "STATE", nullable = false)
    var state: String,

    @Column(name = "COUNTRY", nullable = false)
    var country: String,

    @Column(name = "POSTAL_CODE", nullable = false)
    var postalCode: String,
)
