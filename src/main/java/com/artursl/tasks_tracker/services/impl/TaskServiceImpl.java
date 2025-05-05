package com.artursl.tasks_tracker.services.impl;

import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Task;
import com.artursl.tasks_tracker.exceptions.NoSuchEntityExistsException;
import com.artursl.tasks_tracker.mappers.TaskMapper;
import com.artursl.tasks_tracker.repositories.BoardRepository;
import com.artursl.tasks_tracker.repositories.TaskRepository;
import com.artursl.tasks_tracker.services.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, BoardRepository boardRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
        this.taskMapper = taskMapper;
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
    public TaskDto.Updated updateTask(UUID id, TaskDto.Update taskDto) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new NoSuchEntityExistsException("No task found with id: " + id));
        entity.setTitle(taskDto.title());
        entity.setDescription(taskDto.description());
        entity.setPriority(taskDto.priority());

        Task updatedEntity = taskRepository.save(entity);
        return taskMapper.toUpdatedDto(updatedEntity);
    }
}
