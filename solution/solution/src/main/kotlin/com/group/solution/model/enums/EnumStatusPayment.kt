package com.group.solution.model.enums

enum class EnumStatusPayment(val status: String) {
    PENDING ("Pending payment"),
    PAID("Payment completed"),
    CANCELLED("Payment canceled"),
    FAILED("Payment failed")
}
