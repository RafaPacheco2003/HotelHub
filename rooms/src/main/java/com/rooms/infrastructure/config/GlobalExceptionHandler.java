package com.rooms.infrastructure.config;

import com.rooms.domian.exceptions.DomainException;
import com.rooms.infrastructure.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        HttpStatus status = ex.getErrorCode().contains("NOT_FOUND") ? HttpStatus.NOT_FOUND :
                ex.getErrorCode().contains("ALREADY_EXISTS") ? HttpStatus.CONFLICT :
                        HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(new ErrorResponse(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException() {
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse("INTERNAL_ERROR", "An unexpected error occurred"));
    }
}