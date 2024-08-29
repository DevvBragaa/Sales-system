package com.group.solution.model.entities

import com.group.solution.model.enums.EnumStatusPayment
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "tb_revenue")
class Revenue(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "total_income", nullable = false)
    var totalIncome: Double,  // valor total da receita gerada

    @Column(name = "total_expenses", nullable = false)
    var totalExpenses: Double,  // valor total das despesas realizadas

    @Column(name = "net_revenue", nullable = false)
    var netRevenue: Double,  // valor da receita líquida (totalIncome - totalExpenses)

    @Column(name = "revenue_date", nullable = false)
    var revenueDate: LocalDate,  // data da receita

    @Column(name = "description")
    var description: String? = null,  // descrição da receita

    @Column(name = "category")
    var category: String? = null,  // categoria da receita

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    var paymentStatus: EnumStatusPayment? = null,  // status do pagamento da receita

    @Column(name = "tax")
    var tax: Double? = null,  // imposto sobre a receita

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null,  // cliente que recebeu a receita

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null  // usuário que gerou a receita
)
