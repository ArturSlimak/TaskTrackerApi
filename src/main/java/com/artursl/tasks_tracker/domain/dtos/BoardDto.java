package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BoardDto() {
    public record Create(
            @NotEmpty
            String name
    ) {
    }

    public record GetAll(
            UUID id,
            String name
    ) {
    }

    public record GetById(
            UUID id,
            String name,
            ListResponse<ColumnDto.GetById> columns,
            List<TaskDto.GetById> tasks
    ) {
    }

    public record Update(
            @NotEmpty
            String name
    ) {
    }
}






