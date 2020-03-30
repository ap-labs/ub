package ru.aplabs.ub

import com.fasterxml.jackson.annotation.JsonProperty
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.RuntimeException

data class InitRequest(@JsonProperty("TerminalKey") val terminalKey: String,
                       @JsonProperty("Amount") val amount: Long,
                       @JsonProperty("OrderId") val orderId: String,
                       @JsonProperty("Description") val description: String = "",
                       @JsonProperty("DATA") val data: Map<String, String> = mapOf())

data class InitResponse(@JsonProperty("Success") val success: Boolean,
                        @JsonProperty("ErrorCode") val errorCode: String,
                        @JsonProperty("TerminalKey") val terminalKey: String,
                        @JsonProperty("Status") val status: String,
                        @JsonProperty("PaymentId") val paymentId: String,
                        @JsonProperty("OrderId") val orderId: String,
                        @JsonProperty("Amount") val amount: Long,
                        @JsonProperty("PaymentURL") val paymentURL: String)

data class GetStateRequest(@JsonProperty("TerminalKey") val terminalKey: String,
                           @JsonProperty("PaymentId") val paymentId: String,
                           @JsonProperty("Token") val token: String)

data class GetStateResponse(@JsonProperty("Success") val success: Boolean,
                            @JsonProperty("ErrorCode") val errorCode: String,
                            @JsonProperty("Message") val message: String,
                            @JsonProperty("TerminalKey") val terminalKey: String,
                            @JsonProperty("Status") val status: Status,
                            @JsonProperty("PaymentId") val paymentId: String,
                            @JsonProperty("OrderId") val orderId: String)

//data class CancelRequest()
//data class CancelResponse()

/**
 * Payment status def (see all descriptions in docs - https://oplata.tinkoff.ru/develop/api/payments/)
 */
enum class Status {
    NEW,
    FORMSHOWED,
    DEADLINE_EXPIRED,
    CANCELED,
    PREAUTHORIZING,
    AUTHORIZING,
    AUTHORIZED,
    AUTH_FAIL,
    REJECTED,
    `3DS_CHECKING`,
    `3DS_CHECKED`,
    REVERSING,
    REVERSED,
    CONFIRMING,
    CONFIRMED,
    REFUNDING,
    PARTIAL_REFUNDED,
    REFUNDED
}

class TinkoffGate {

    private val log = loggerFor<TinkoffGate>()
    private val url = "https://securepay.tinkoff.ru/v2"
    private val client = OkHttpClient()

    fun init() {
        val request = Request.Builder()
                .url("$url/Init")
                .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                // log
            }

        }
    }

    fun getState() {

    }

    fun cancel() {
        // stub
    }
}
