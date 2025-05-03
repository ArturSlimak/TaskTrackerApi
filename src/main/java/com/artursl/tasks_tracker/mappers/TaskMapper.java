package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    Task toModel(TaskDto taskDto);
    TaskDto toDto(Task task);
}
