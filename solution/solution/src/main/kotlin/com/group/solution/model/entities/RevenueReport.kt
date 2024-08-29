import com.group.solution.model.entities.User
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "tb_revenue_report")
class RevenueReport(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "report_date", nullable = false)
    val reportDate: LocalDate,  // Data de geração do relatório

    @Column(name = "total_revenue", nullable = false)
    val totalRevenue: Double,  // Receita total somada de todas as receitas

    @Column(name = "total_expenses", nullable = false)
    val totalExpenses: Double,  // Despesas totais somadas de todas as receitas

    @Column(name = "net_revenue", nullable = false)
    val netRevenue: Double,  // Receita líquida total (totalRevenue - totalExpenses)

    @Column(name = "number_of_transactions", nullable = false)
    val numberOfTransactions: Int,  // Número total de transações incluídas no relatório

    @Column(name = "highest_revenue", nullable = false)
    val highestRevenue: Double,  // Maior receita em uma única transação

    @Column(name = "lowest_revenue", nullable = false)
    val lowestRevenue: Double,  // Menor receita em uma única transação

    @Column(name = "average_revenue", nullable = false)
    val averageRevenue: Double,  // Receita média por transação

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User? = null  // Usuário que gerou o relatório
)
