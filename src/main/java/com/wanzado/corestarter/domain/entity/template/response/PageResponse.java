package com.wanzado.corestarter.domain.entity.template.response;

import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PageResponse<T>(
        List<T> content,
        Boolean success,
        String message,
        String errorCode,
        String httpStatus,
        LocalDateTime responseAt,
        Metadata metadata
) {

    @Builder
    public record Metadata(
            String sorter,
            Integer current,
            Integer pageSize
    ) {}

    public static <T> PageResponse<T> success(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .success(true)
                .message("Success")
                .responseAt(LocalDateTime.now())
                .httpStatus(String.valueOf(HttpStatus.OK.value()))
                .metadata(
                        Metadata.builder()
                                .sorter(page.getSort().toString())
                                .current(page.getNumber())
                                .pageSize(page.getSize())
                                .build()
                )
                .build();
    }

    public static <T> PageResponse<T> fail(String message, String errorCode, HttpStatus httpStatus) {
        return PageResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .httpStatus(String.valueOf(httpStatus.value()))
                .responseAt(LocalDateTime.now())
                .build();
    }
}
