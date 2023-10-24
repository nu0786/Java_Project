package com.transactionservice.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@JsonIgnoreProperties("stackTrace")
@Getter
@Setter
@Slf4j
public class TransactionServiceApiException extends Exception {

    public TransactionServiceApiException() {

    }

    public TransactionServiceApiException(String message) {
        super(message);
    }

    public TransactionServiceApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
