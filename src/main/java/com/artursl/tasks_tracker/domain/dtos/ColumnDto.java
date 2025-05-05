package com.artursl.tasks_tracker.domain.dtos;

import com.artursl.tasks_tracker.domain.entities.Task;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record ColumnDto() {
    public record GetById(
            UUID id,
            String name,
            int position,
            List<TaskDto.GetById> tasks
    ) {
    }

    public record Create(
            @NotEmpty
            String name,

            @NotNull
            int position
    ) {
    }

    public record Created(
            UUID id,
            String name,
            int position) {
    }

    public record Update(
            @NotEmpty
            String name
    ) {
    }

    public record Updated(
            UUID id,
            String name
    ) {
    }

    public record Move(
            int position
    ) {
    }


}
