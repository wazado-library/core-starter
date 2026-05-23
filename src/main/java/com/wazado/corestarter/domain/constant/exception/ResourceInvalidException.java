package com.wazado.corestarter.domain.constant.exception;

import com.wazado.corestarter.domain.constant.enums.EErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceInvalidException extends RuntimeException{
    String errorCode;

    public ResourceInvalidException(String message) {
        super(message);
        this.errorCode = EErrorCode.SYS_003.getCode();
    }

    public ResourceInvalidException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceInvalidException() {
        super("Resource not found");
        this.errorCode = EErrorCode.SYS_003.getCode();
    }
}
