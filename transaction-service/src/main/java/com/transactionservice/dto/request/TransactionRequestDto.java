package com.transactionservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactionservice.constants.ExceptionConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransactionRequestDto {

    @NotNull(message = ExceptionConstant.MANDATORY_FIELD_MISSING)
    @JsonProperty("account_id")
    private Long accountId;

    @NotNull(message = ExceptionConstant.MANDATORY_FIELD_MISSING)
    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    @NotNull(message = ExceptionConstant.MANDATORY_FIELD_MISSING)
    @DecimalMin(value = "0.01", message = ExceptionConstant.AMOUNT_VALUE_ERROR)
    private Double amount;
}
