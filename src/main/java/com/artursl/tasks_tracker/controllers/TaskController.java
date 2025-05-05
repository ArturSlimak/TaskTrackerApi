package com.artursl.tasks_tracker.controllers;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.services.TaskService;
import jakarta.validation.Valid;
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
    public ResponseEntity<TaskDto.Created> createTask(@PathVariable UUID id, @Valid @RequestBody TaskDto.Create taskDto) {
        TaskDto.Created createdTask = taskService.createTask(id, taskDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdTask.id()).build().toUri();
        return ResponseEntity.created(location).body(createdTask);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto.Updated> updateTask(@PathVariable UUID id, @Valid @RequestBody TaskDto.Update taskDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @PatchMapping("tasks/{id}/move")
    public ResponseEntity<TaskDto.GetById> moveTask(@PathVariable UUID id, @Valid @RequestBody TaskDto.Move taskDto) {
        return ResponseEntity.ok(taskService.move(id, taskDto));
    }


}
