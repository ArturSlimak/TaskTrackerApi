package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public record BoardDto() {
    public record Create(
            String name
    ){}

    public record GetAll(
            UUID id,
            String name
    ) {}

    public record GetById(
            UUID id,
            String name,
            List<ColumnDto> columns,
            List<TaskDto> tasks
    ){}
}






