package ru.aplabs.ub

import io.javalin.Javalin

fun main() {
    val app = Javalin.create()
    app.start(8080)
}
