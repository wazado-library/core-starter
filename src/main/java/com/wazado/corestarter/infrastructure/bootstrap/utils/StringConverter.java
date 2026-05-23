package com.wazado.corestarter.infrastructure.bootstrap.utils;

import org.springframework.util.StringUtils;

import java.text.Normalizer;

public class StringConverter {
    public static String toAscii(String source) {
        if (!StringUtils.hasText(source)) {
            return "";
        }
        String normalizerStr = Normalizer.normalize(source, Normalizer.Form.NFD);
        return normalizerStr
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replace("đ", "d")
                .replace("Đ", "d")
                .toLowerCase();
    }
}
