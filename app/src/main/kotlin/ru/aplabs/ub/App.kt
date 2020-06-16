package ru.aplabs.ub

import io.javalin.Javalin
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import ru.aplabs.ub.util.Utils

fun main() {
    val app = Javalin.create()
    app.start(8080)
    val ctx = DSL.using(Utils.ds(), SQLDialect.POSTGRES)
    val ub = UB(ctx)
}
