package com.artursl.tasks_tracker;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import com.artursl.tasks_tracker.domain.entities.TaskPriority;
import com.artursl.tasks_tracker.mappers.BoardMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class BoardMapperTests {

/*    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void BoardModelToDto_whenMap_thenCorrect() {
        Board board = new Board();
        board.setId(UUID.randomUUID());
        board.setName("Sprint Board");


        Columnn column = new Columnn();
        column.setId(UUID.randomUUID());
        column.setName("To Do");
        column.setPosition(0);
        column.setBoard(board);

        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setTitle("Task 1");
        task.setPriority(TaskPriority.HIGH);
        task.setBoard(board);
        task.setColumn(column);

        board.setColumns(List.of(column));
        board.setTasks(List.of(task));

        BoardDto dto = boardMapper.toDto(board);

        Assertions.assertEquals(board.getId(), dto.id());
        Assertions.assertEquals(board.getName(), dto.name());
        Assertions.assertEquals(1, dto.columns().size());
        Assertions.assertEquals(1, dto.tasks().size());
        Assertions.assertEquals("Task 1", dto.tasks().getFirst().title());
    }*/
}
