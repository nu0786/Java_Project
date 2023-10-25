package com.transactionservice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(value = {"stackTrace", "suppressed"}, ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String message;
    private String languageCode;
    private List<String> errors;

    private String detailMessage;

    private String shortMessage;

    ApiException(String errorCode, String message, String languageCode, List<String> errors) {
        this.errorCode = errorCode;
        this.message = message;
        this.languageCode = languageCode;
        this.errors = errors;
    }

    ApiException(String errorCode, String message, String languageCode) {
        this.message = message;
        this.errorCode = errorCode;
        this.languageCode = languageCode;
    }

    @JsonIgnore
    public String getDetailMessage() {
        return detailMessage;
    }

    @JsonProperty
    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    @JsonIgnore
    public String getShortMessage() {
        return shortMessage;
    }

    @JsonProperty
    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }
}