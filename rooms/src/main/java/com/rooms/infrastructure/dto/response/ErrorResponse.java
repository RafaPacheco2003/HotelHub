package com.rooms.infrastructure.dto.response;

public record ErrorResponse(
        String errorCode,
        String message,
        String timestamp
) {
    public ErrorResponse(String errorCode, String message) {
        this(errorCode, message, java.time.LocalDateTime.now().toString());
    }
}