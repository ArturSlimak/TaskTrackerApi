package com.artursl.tasks_tracker.services;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;

import java.util.UUID;

public interface TaskService {
    TaskDto.Created createTask(UUID boardId, TaskDto.Create taskDto);
    TaskDto.Updated updateTask(UUID id, TaskDto.Update taskDto);
}
