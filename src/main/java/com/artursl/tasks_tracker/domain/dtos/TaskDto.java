package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.TaskPriority;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(

) {

    public record GetOverviewDto(
            UUID id,
            String title,
            String description,
            TaskPriority priority
    ) {
    }

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

    public record Created(
            UUID id,
            String title,
            String description,
            TaskPriority priority
    ) {
    }

    public record Update(
            @NotEmpty
            String title,
            String description,
            TaskPriority priority
    ) {
    }

    public record Updated(
            UUID id,
            String title,
            String description,
            TaskPriority priority
    ) {
    }


    public record Move(
            @Nullable
            UUID columnId
    ) {

    }
}
