package com.transactionservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactionservice.constants.error.ApiErrorCodes;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AccountRequestDto {

    @NotBlank(message = ApiErrorCodes.MANDATORY_FIELD_MISSING)
    @JsonProperty("document_number")
    public String documentNumber;
}