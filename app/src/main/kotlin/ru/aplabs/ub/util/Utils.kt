package ru.aplabs.ub.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
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

    fun dataSource(url: String = "jdbc:postgresql://localhost:5432/postgres",
                   username: String = "postgres",
                   password: String = "postgres",
                   limit: Int = 5): DataSource {
        val config = HikariConfig()
        config.jdbcUrl = url
        config.username = username
        config.password = password
        config.maximumPoolSize = limit
        return HikariDataSource(config)
    }

    fun flyway(dataSource: DataSource): Flyway {
        return Flyway.configure()
                .dataSource(dataSource)
                .load()
    }
}
