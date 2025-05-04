package com.artursl.tasks_tracker;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import com.artursl.tasks_tracker.domain.entities.TaskPriority;
import com.artursl.tasks_tracker.mappers.ColumnMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class ColumnMapperTests {
    @Autowired
    private ColumnMapper columnMapper;

/*
    @Test
public void ColumnEntityToDto_whenMap_thenCorrect() {
        Columnn column = new Columnn();
        column.setId(UUID.randomUUID());
        column.setName("TO DO");
        column.setPosition(0);

        Task task1 = new Task();
        task1.setId(UUID.randomUUID());
        task1.setTitle("Task 1");
        task1.setPriority(TaskPriority.HIGH);

        Task task2 = new Task();
        task2.setId(UUID.randomUUID());
        task2.setTitle("Task 2");
        task2.setPriority(TaskPriority.MEDIUM);

        column.setTasks(List.of(task1, task2));

        ColumnDto dto = columnMapper.toDto(column);

        Assertions.assertEquals(column.getId(), dto.id());
        Assertions.assertEquals(column.getName(), dto.name());
        Assertions.assertEquals(column.getPosition(), dto.position());
        Assertions.assertEquals(column.getTasks().size(), dto.tasks().size());
        Assertions.assertEquals(column.getTasks().getFirst().getId(), dto.tasks().getFirst().id());
        Assertions.assertEquals(column.getTasks().get(1).getTitle(), dto.tasks().get(1).title());
    }*/
}
