package com.transactionservice.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transactionservice.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties("stackTrace")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionServiceResponseTemplate<T> {
    private T result;
    private ApiException exception;
    private Paginate pagination;
}
