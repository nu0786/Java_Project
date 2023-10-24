package com.transactionservice.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transactionservice.exception.TransactionServiceApiException;
import lombok.Builder;

@JsonIgnoreProperties("stackTrace")
public class TransactionServiceResponse {

    private Object result;
    private TransactionServiceApiException exception;
    private Paginate pagination;

    public TransactionServiceResponse() {

    }
    
    @Builder
    public TransactionServiceResponse(Object result, TransactionServiceApiException exception, Paginate pagination) {
        this.result = result;
        this.exception = exception;
        this.pagination = pagination;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public TransactionServiceApiException getException() {
        return exception;
    }

    public void setException(TransactionServiceApiException exception) {
        this.exception = exception;
    }

    public Paginate getPagination() {
        return pagination;
    }

    public void setPagination(Paginate pagination) {
        this.pagination = pagination;
    }
}
