package ru.aplabs.ub

import org.slf4j.LoggerFactory

internal inline fun <reified T> loggerFor() = LoggerFactory.getLogger(T::class.java)
