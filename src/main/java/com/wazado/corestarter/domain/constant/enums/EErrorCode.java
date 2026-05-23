package com.wazado.corestarter.domain.constant.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum EErrorCode {
    SYS_001("SYS_001"),
    SYS_002("SYS_002"),
    SYS_003("SYS_003"),
    SYS_004("SYS_004"),
    SYS_005("SYS_005");

    String code;
}
