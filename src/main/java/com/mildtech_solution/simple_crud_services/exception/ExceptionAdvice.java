package com.mildtech_solution.simple_crud_services.exception;

import com.mildtech_solution.simple_crud_services.domain.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseResponse> handleException(ResponseStatusException e){
        String reason = StringUtils.hasText(e.getReason()) ? e.getReason() : e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse(e.getMessage(), reason));
    }
}
