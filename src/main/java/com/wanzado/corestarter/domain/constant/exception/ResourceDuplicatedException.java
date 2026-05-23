package com.wanzado.corestarter.domain.constant.exception;

import com.wanzado.corestarter.domain.constant.enums.EErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceDuplicatedException extends RuntimeException{
    String errorCode;

    public ResourceDuplicatedException(String message) {
        super(message);
        this.errorCode = EErrorCode.SYS_002.getCode();
    }

    public ResourceDuplicatedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceDuplicatedException() {
        super("Resource duplicated");
        this.errorCode = EErrorCode.SYS_002.getCode();
    }
}
