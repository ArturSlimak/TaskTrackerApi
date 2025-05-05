package com.artursl.tasks_tracker.domain.dtos;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty
        String email,
        @NotEmpty
        String password
) {

}
