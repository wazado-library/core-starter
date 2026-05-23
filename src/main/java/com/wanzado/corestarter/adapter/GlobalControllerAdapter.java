package com.wanzado.corestarter.adapter;

import com.wanzado.corestarter.domain.constant.enums.EErrorCode;
import com.wanzado.corestarter.domain.constant.exception.ResourceDuplicatedException;
import com.wanzado.corestarter.domain.constant.exception.ResourceInvalidException;
import com.wanzado.corestarter.domain.constant.exception.ResourceNotFoundException;
import com.wanzado.corestarter.domain.entity.template.response.ValueResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdapter {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ValueResponse<?>> resourceNotFoundHandler(ResourceNotFoundException e) {
        return ResponseEntity.ok(ValueResponse.fail(e.getMessage(), e.getErrorCode(),  HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(ResourceDuplicatedException.class)
    ResponseEntity<ValueResponse<?>> resourceDuplicatedHandler(ResourceDuplicatedException e) {
        return ResponseEntity.ok(ValueResponse.fail(e.getMessage(), e.getErrorCode(),  HttpStatus.CONFLICT));
    }

    @ExceptionHandler(ResourceInvalidException.class)
    ResponseEntity<ValueResponse<?>> resourceInvalidHandler(ResourceInvalidException e) {
        return ResponseEntity.ok(ValueResponse.fail(e.getMessage(), e.getErrorCode(),  HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> err = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(f -> {
            err.put(f.getField(), f.getDefaultMessage());
        });
        String message = String.join(", ", err.values());
        ValueResponse<?> valueResponse = ValueResponse.fail(message, EErrorCode.SYS_004.getCode(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(valueResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> resourceDuplicateExceptionHandler(NullPointerException e) {
        ValueResponse<?> valueResponse = ValueResponse.fail(e.getMessage(), EErrorCode.SYS_005.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(valueResponse);
    }
}
