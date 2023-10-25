package com.transactionservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactionservice.constants.error.ApiErrorCodes;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransactionRequestDto {

    @NotNull(message = ApiErrorCodes.MANDATORY_FIELD_MISSING)
    @JsonProperty("account_id")
    private Long accountId;

    @NotNull(message = ApiErrorCodes.MANDATORY_FIELD_MISSING)
    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    @NotNull(message = ApiErrorCodes.MANDATORY_FIELD_MISSING)
    @DecimalMin(value = "0.01", message = ApiErrorCodes.INVALID_AMOUNT)
    private Double amount;
}
