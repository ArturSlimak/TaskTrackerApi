package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.TaskPriority;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        TaskPriority priority
) {

}
