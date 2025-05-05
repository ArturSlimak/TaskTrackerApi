package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.TaskPriority;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(

) {

    public record GetById(
            UUID id,
            String title,
            String description,
            TaskPriority priority
    ) {
    }

    public record Create(
            @NotEmpty
            String title,
            String description,

            TaskPriority priority
    ) {
    }
}
