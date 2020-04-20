package ru.aplabs.ub

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.slf4j.LoggerFactory

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
}
