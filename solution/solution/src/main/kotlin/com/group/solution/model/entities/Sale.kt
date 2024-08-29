package com.group.solution.model.entities

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "tb_sale")
class Sale (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name="saleDate")
    var saleDate: LocalDateTime,

    @Column(name="totalValue")
    var totalValue: Double,

    @Column(name="tax")
    var tax: Double,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val user: User
)

