package com.artursl.tasks_tracker;


import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import com.artursl.tasks_tracker.domain.entities.TaskPriority;
import com.artursl.tasks_tracker.mappers.TaskMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class TaskMapperTests {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void TaskEntityToDto_whenMap_thenCorrect() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setTitle("Get up");
        task.setDescription("Try to not fall asleep again");
        task.setPriority(TaskPriority.HIGH);

        TaskDto dto = taskMapper.toDto(task);

        Assertions.assertEquals(task.getId(), dto.id());
        Assertions.assertEquals(task.getTitle(), dto.title());
        Assertions.assertEquals(task.getDescription(), dto.description());
        Assertions.assertEquals(task.getPriority(), dto.priority());

    }

    @Test
    public void TaskDtoToEntity_whenMap_thenCorrect() {
        TaskDto dto = new TaskDto(
                UUID.randomUUID(),
                "Get up",
                "Try to not fall asleep again",
                TaskPriority.HIGH
        );

        Task task = taskMapper.toEntity(dto);

        Assertions.assertEquals(dto.id(), task.getId());
        Assertions.assertEquals(dto.title(), task.getTitle());
        Assertions.assertEquals(dto.description(), task.getDescription());
        Assertions.assertEquals(dto.priority(), task.getPriority());


    }


}
