package com.artursl.tasks_tracker.services;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface TaskService {
    TaskDto.GetById getTaskById(UUID id);
    TaskDto.Created createTask(UUID boardId, TaskDto.Create taskDto);
    TaskDto.Updated updateTask(UUID id, TaskDto.Update taskDto);
    TaskDto.GetById move(UUID id, TaskDto.Move taskDto);
    void deleteTask(UUID id);
}
