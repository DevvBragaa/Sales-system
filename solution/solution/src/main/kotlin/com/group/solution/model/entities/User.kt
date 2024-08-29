package com.group.solution.model.entities

import RevenueReport
import jakarta.persistence.*

@Entity
@Table(name = "tb_users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long?=null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "cpf", nullable = false, unique = true)
    var cnpj: String,

    @Column(name = "occupation", nullable = false)
    var occupation: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var address: Address? =null,

    @OneToMany(mappedBy = "id", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var revenueReports: List<RevenueReport> = mutableListOf()  // Relacionamento com a entidade RevenueReport
)
