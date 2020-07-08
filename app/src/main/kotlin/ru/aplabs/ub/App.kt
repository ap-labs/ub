package ru.aplabs.ub

import io.javalin.Javalin
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import ru.aplabs.ub.util.Utils
import ru.aplabs.ub.util.loggerFor

class App(private val properties: Map<String, String> = mapOf()) {

    private val log = loggerFor<App>()


    val ds = Utils.dataSource()
    val flyway = Utils.flyway(ds)
    val ctx = DSL.using(ds, SQLDialect.POSTGRES)

    fun start() {
        flyway.migrate()
        val app = Javalin.create()
        val ub = UB(ctx)
        app.start(8080)
        log.info("App started!")
    }
}

fun main() {
    val app = App()
    app.start()
}
