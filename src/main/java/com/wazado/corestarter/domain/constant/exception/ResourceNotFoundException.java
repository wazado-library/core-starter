package com.wazado.corestarter.domain.constant.exception;

import com.wazado.corestarter.domain.constant.enums.EErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceNotFoundException extends RuntimeException {
    String errorCode;

    public ResourceNotFoundException(String message) {
        super(message);
        this.errorCode = EErrorCode.SYS_001.getCode();
    }

    public ResourceNotFoundException(String message,  String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException() {
        super("Resource not found");
        this.errorCode = EErrorCode.SYS_001.getCode();
    }
}
