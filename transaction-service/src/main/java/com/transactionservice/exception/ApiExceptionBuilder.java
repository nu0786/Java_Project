package com.transactionservice.exception;

import com.transactionservice.constants.error.ApiErrors;
import lombok.extern.slf4j.Slf4j;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

@Slf4j
public class ApiExceptionBuilder {

    public static ApiException build(ApiErrors errorCode) {
        return new ApiException(errorCode.getCode(), errorCode.getMessage(), Locale.US.getLanguage());
    }
}