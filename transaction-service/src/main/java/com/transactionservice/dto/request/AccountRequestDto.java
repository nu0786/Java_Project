package com.transactionservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactionservice.constants.ExceptionConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AccountRequestDto {

    @NotBlank(message = ExceptionConstant.MANDATORY_FIELD_MISSING)
    @JsonProperty("document_number")
    public String documentNumber;
}