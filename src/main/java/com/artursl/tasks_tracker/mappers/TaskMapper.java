package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TaskMapper {
    Task toEntity(TaskDto.Create taskDto);
    TaskDto toDto(Task task);
    TaskDto.GetById toGetById(Task task);
    TaskDto.Created toCreatedDto(Task task);
    TaskDto.Updated toUpdatedDto(Task task);
}
