package com.transactionservice.constants.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrors {
    INVALID_DATA("TS_001", "Invalid Data"),
    MANDATORY_FIELD_MISSING("TS_002", "Mandatory Field {0} Is Missing"),
    INVALID_AMOUNT("TS_003", "Amount {0} Is Invalid"),
    REMOTE_CALL_FAILED("TS_004", "Remote Call failed"),
    INVALID_REQUEST("TS_005", "Invalid Request"),
    UNABLE_TO_SAVE_DATA("TS_006", "Unable To Save Data"),
    OPERATION_TYPE_NOT_FOUND("TS_007", "Operation Type Not Found"),
    ACCOUNT_NOT_FOUND("TS_008", "Account Not Found"),
    INTERNAL_SERVER_ERROR("TS_009", "Internal Server Error"),;

    private final String code;
    private final String message;
}