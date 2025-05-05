package com.artursl.tasks_tracker.controllers;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
@Validated
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("boards/{id}/tasks")
    public ResponseEntity<TaskDto.GetById> createTask(@PathVariable UUID id, @RequestBody TaskDto.Create taskDto) {
        TaskDto.GetById createdTask = taskService.createTask(id, taskDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdTask.id()).build().toUri();
        return ResponseEntity.created(location).body(createdTask);
    }
}
