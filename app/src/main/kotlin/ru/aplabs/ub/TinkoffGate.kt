package ru.aplabs.ub

import com.fasterxml.jackson.annotation.JsonProperty
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import ru.aplabs.ub.util.Utils
import ru.aplabs.ub.util.loggerFor
import java.math.BigDecimal
import java.util.*


enum class TaxationSystems {
    osn, usn_income, usn_income_outcome, patent, envd, esn
}

data class Receipt(@JsonProperty("Email") val email: String? = null,
                   @JsonProperty("Phone") val phone: String? = null,
                   @JsonProperty("Taxation") val taxation: TaxationSystems = TaxationSystems.usn_income,
                   @JsonProperty("Items") val items: List<ReceiptItem> = listOf())

data class ReceiptItem(@JsonProperty("Name") val name: String,
                       @JsonProperty("Price") val price: Long,
                       @JsonProperty("Quantity") val quantity: BigDecimal = BigDecimal.ONE,
                       @JsonProperty("Amount") val amount: Long = quantity.multiply(BigDecimal.valueOf(price)).toLong(),
                       @JsonProperty("PaymentMethod") val paymentMethod: String = "prepayment",
                       @JsonProperty("PaymentObject") val paymentObject: String = "service",
                       @JsonProperty("Tax") val tax: String = "none")


data class InitRequest(@JsonProperty("TerminalKey") val terminalKey: String,
                       @JsonProperty("Amount") val amount: Long,
                       @JsonProperty("OrderId") val orderId: String,
                       @JsonProperty("PayType") val payType: String = "O",
                       @JsonProperty("Description") val description: String = "",
                       @JsonProperty("Recurrent") val recurrent: String? = null,
                       @JsonProperty("CustomerKey") val customerKey: String? = null,
                       @JsonProperty("SuccessURL") val successURL: String? = null,
                       @JsonProperty("FailURL") val failURL: String? = null,
                       @JsonProperty("Receipt") val receipt: Receipt? = null,
                       @JsonProperty("DATA") val data: Map<String, String> = mapOf()) {
}

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

data class ConfirmRequest(@JsonProperty("TerminalKey") val terminalKey: String,
                          @JsonProperty("PaymentId") val paymentId: String,
                          @JsonProperty("Token") val token: String)

data class ConfirmResponse(@JsonProperty("Success") val success: Boolean,
                           @JsonProperty("ErrorCode") val errorCode: String,
                           @JsonProperty("Message") val message: String,
                           @JsonProperty("TerminalKey") val terminalKey: String,
                           @JsonProperty("Status") val status: Status,
                           @JsonProperty("PaymentId") val paymentId: String,
                           @JsonProperty("OrderId") val orderId: String)

data class CancelRequest(@JsonProperty("TerminalKey") val terminalKey: String,
                         @JsonProperty("PaymentId") val paymentId: String,
                         @JsonProperty("Token") val token: String)

data class CancelResponse(@JsonProperty("Success") val success: Boolean,
                          @JsonProperty("ErrorCode") val errorCode: String,
                          @JsonProperty("TerminalKey") val terminalKey: String,
                          @JsonProperty("Status") val status: Status,
                          @JsonProperty("PaymentId") val paymentId: String,
                          @JsonProperty("OrderId") val orderId: String,
                          @JsonProperty("OriginalAmount") val originalAmount: Long,
                          @JsonProperty("NewAmount") val newAmount: Long)

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
    REFUNDED,
    UNKNOWN
}

class TinkoffGate {

}

class TinkoffGateClient {

    private val log = loggerFor<TinkoffGateClient>()
    private val url = "https://securepay.tinkoff.ru/v2"
    private val client = OkHttpClient()

    fun init(value: InitRequest): InitResponse = call("Init", value)

    fun getState(value: GetStateRequest): GetStateResponse = call("GetState", value)

    fun confirm(value: ConfirmRequest): ConfirmResponse = call("Confirm", value)

    fun cancel(value: CancelRequest): CancelResponse = call("Cancel", value)

    private inline fun <reified REQ, reified RESP> call(method: String, value: REQ): RESP {
        log.debug("""Calling "$method" with value: "$value" """)
        val initial = Date().time
        val request = Request.Builder()
                .url("$url/$method")
                .post(Utils.mapper.writeValueAsString(value).toRequestBody())
                .build()
        client.newCall(request).execute().use {
            val responseBody = it.body!!.string()
            if (!it.isSuccessful) {
                log.debug("""Failed to execute method "$method", code: ${it.code}, response: "$responseBody"""")
                throw RuntimeException("Call method returned non-successful code")
            }
            val result = Utils.mapper.readValue(responseBody, RESP::class.java)
            val time = Date().time - initial
            log.debug("Calling $method successfully finished in ${time}ms")
            return result
        }
    }
}
