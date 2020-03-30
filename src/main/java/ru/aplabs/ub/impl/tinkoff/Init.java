package ru.aplabs.ub.impl.tinkoff;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

public class Init {

    @Data
    public static class Request {

        @JsonProperty("TerminalKey")
        private String terminalKey;
        @JsonProperty("Amount")
        private Long amount;
        @JsonProperty("OrderId")
        private String orderId;
        @JsonProperty("Description")
        private String description;
        @JsonProperty("DATA")
        private Map<String, String> data;
    }

    @Data
    public static class Response {

        @JsonProperty("Success")
        private Boolean success;
        @JsonProperty("ErrorCode")
        private String errorCode;
        @JsonProperty("TerminalKey")
        private String terminalKey;
        @JsonProperty("Status")
        private String status;
        @JsonProperty("PaymentId")
        private String paymentId;
        @JsonProperty("OrderId")
        private String orderId;
        @JsonProperty("Amount")
        private Long amount;
        @JsonProperty("PaymentURL")
        private String paymentURL;
    }
}
