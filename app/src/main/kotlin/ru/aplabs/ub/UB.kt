package ru.aplabs.ub

import org.jooq.DSLContext
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class UB(private val ctx: DSLContext) {

    fun startSubscription(account: String, plan: String) {


    }

    fun cancelSubscription(account: String, plan: String) {

    }

    fun plans(): List<Plan> {
//        ctx.
        return emptyList()
    }

    fun history(account: String): List<PaymentItem> {
        return listOf()
    }
}

data class Account(val id: String, val plan: String)

data class Plan(val id: String, val description: String, val price: Long)

data class PaymentItem(val id: UUID, val plan: String, val sum: BigDecimal, val timeKey: LocalDateTime)
