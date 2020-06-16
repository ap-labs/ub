package ru.aplabs.ub.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.slf4j.LoggerFactory
import javax.sql.DataSource

internal inline fun <reified T> loggerFor() = LoggerFactory.getLogger(T::class.java)

object Utils {
    val mapper: ObjectMapper by lazy {
        val mapper = ObjectMapper()
        mapper.registerModules(JavaTimeModule())
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun ds(): DataSource {
        val config = HikariConfig()
        val ds = HikariDataSource()
        return ds
    }
}
