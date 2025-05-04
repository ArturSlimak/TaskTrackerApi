package com.artursl.tasks_tracker.domain.dtos;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
