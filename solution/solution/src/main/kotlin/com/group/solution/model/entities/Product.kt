package com.group.solution.model.entities

import com.group.solution.model.enums.EnumTypeProduct
import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column (name = "type_product")
    var typeProduct: EnumTypeProduct,

    @Column (name = "description")
    var description: String,

    @Column (name = "price")
    var price: Double,

    @Column (name = "quantity_in_stock")
    var quantityInStock: Int,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User
) {

}