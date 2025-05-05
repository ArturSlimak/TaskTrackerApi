package com.artursl.tasks_tracker.services.impl;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import com.artursl.tasks_tracker.exceptions.NoSuchEntityExistsException;
import com.artursl.tasks_tracker.exceptions.NotTheSameBoardException;
import com.artursl.tasks_tracker.mappers.TaskMapper;
import com.artursl.tasks_tracker.repositories.BoardRepository;
import com.artursl.tasks_tracker.repositories.ColumnRepository;
import com.artursl.tasks_tracker.repositories.TaskRepository;
import com.artursl.tasks_tracker.services.ColumnService;
import com.artursl.tasks_tracker.services.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;
    private final TaskMapper taskMapper;
    private final ColumnRepository columnRepository;

    public TaskServiceImpl(TaskRepository taskRepository, BoardRepository boardRepository, TaskMapper taskMapper, ColumnRepository columnRepository) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
        this.taskMapper = taskMapper;
        this.columnRepository = columnRepository;

    }

    @Override
    @Transactional
    public TaskDto.Created createTask(UUID boardId, TaskDto.Create taskDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchEntityExistsException("No board found with id: " + boardId));

        Task entity = taskMapper.toEntity(taskDto);
        entity.setBoard(board);
        Task savedEntity = taskRepository.save(entity);
        return taskMapper.toCreatedDto(savedEntity);
    }

    @Override
    @Transactional
    public TaskDto.Updated updateTask(UUID id, TaskDto.Update taskDto) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new NoSuchEntityExistsException("No task found with id: " + id));
        entity.setTitle(taskDto.title());
        entity.setDescription(taskDto.description());
        entity.setPriority(taskDto.priority());

        Task updatedEntity = taskRepository.save(entity);
        return taskMapper.toUpdatedDto(updatedEntity);
    }

    @Override
    @Transactional
    public TaskDto.GetById move(UUID id, TaskDto.Move taskDto) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new NoSuchEntityExistsException("No task found with id: " + id));
        UUID columnId = taskDto.columnId();

        if (columnId == null) {
            entity.setColumn(null);
            return taskMapper.toGetById(taskRepository.save(entity));
        }

        Columnn column = columnRepository.findById(columnId).orElseThrow(() -> new NoSuchEntityExistsException("No column found with id: " + taskDto.columnId()));

        if (column.getBoard().getId() != entity.getBoard().getId()) {
            throw new NotTheSameBoardException("Task and column belong to different boards");
        }

        entity.setColumn(column);
        return taskMapper.toGetById(taskRepository.save(entity));

    }

    @Override
    @Transactional
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}
