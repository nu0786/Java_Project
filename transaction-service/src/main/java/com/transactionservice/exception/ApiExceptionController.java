package com.transactionservice.exception;

import com.transactionservice.constants.error.ApiErrors;
import com.transactionservice.dto.response.TransactionServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ApiException.class)
    public static ResponseEntity<Object> apiException(ApiException apiException) {
        log.error("Error in response", apiException);
        return new ResponseEntity<>(TransactionServiceResponse.builder().exception(apiException).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public static ResponseEntity<Object> apiException(IllegalArgumentException exception) {
        log.error("Error in response", exception);
        return new ResponseEntity<>(TransactionServiceResponse.builder().exception(ApiExceptionBuilder.build(ApiErrors.INVALID_DATA)).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public static ResponseEntity<Object> apiException(NullPointerException exception) {
        log.error("Error in response", exception);
        return new ResponseEntity<>(TransactionServiceResponse.builder().exception(ApiExceptionBuilder.build(ApiErrors.INTERNAL_SERVER_ERROR)).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}





