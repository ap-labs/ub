package ru.aplabs.ub

import org.jooq.DSLContext
import ru.aplabs.ub.generated.Tables
import ru.aplabs.ub.util.loggerFor
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class UB(private val ctx: DSLContext) {

    private val log = loggerFor<UB>()

    fun plans(): List<Plan> {
        log.debug("Getting all plans")
        val result = ctx.selectFrom(Tables.PLANS)
                .where(Tables.PLANS.ACTIVE.isTrue)
                .fetch { Plan(it.id, it.description, it.price) }
        log.debug("Fetched ${result.size} plans")
        return result
    }

    fun info(account: String): Info {

    }

    fun startSubscription(account: String, plan: String) {


    }

    fun cancelSubscription(account: String, plan: String) {

    }

    fun history(account: String): List<PaymentItem> {
        return listOf()
    }
}

data class Plan(val id: String, val description: String, val price: Long)

data class Info(val account: String, val plan: String, val )

data class PaymentItem(val id: UUID, val plan: String, val sum: BigDecimal, val timeKey: LocalDateTime)
