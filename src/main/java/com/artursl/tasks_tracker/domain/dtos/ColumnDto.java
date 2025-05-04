package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public record ColumnDto(
        UUID id,
        String name,
        int position,
        List<TaskDto> tasks
) {
}
