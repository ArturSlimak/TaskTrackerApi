package com.artursl.tasks_tracker.domain.dtos;

public record AuthResponse(
        String token,
        long expiresIn
) {
}
