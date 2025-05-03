package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public record BoardDto(
        UUID id,
        String name,
        List<Columnn> columns,
        List<Task> tasks
) {
}
