package com.artursl.tasks_tracker.services.impl;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.exceptions.ColumnPositionIsOutOfBoardSizeException;
import com.artursl.tasks_tracker.exceptions.DoubleColumnPositionException;
import com.artursl.tasks_tracker.exceptions.NoSuchEntityExistsException;
import com.artursl.tasks_tracker.mappers.ColumnMapper;
import com.artursl.tasks_tracker.repositories.BoardRepository;
import com.artursl.tasks_tracker.repositories.ColumnRepository;
import com.artursl.tasks_tracker.services.ColumnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ColumnServiceImpl implements ColumnService {

    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;
    private final ColumnMapper columnMapper;

    public ColumnServiceImpl(ColumnRepository columnRepository,
                             BoardRepository boardRepository,
                             ColumnMapper columnMapper) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
        this.columnMapper = columnMapper;
    }

    @Override
    @Transactional
    public ColumnDto.Created createColumn(UUID boardId, ColumnDto.Create columnDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchEntityExistsException("No board found with id: " + boardId));

        board.getColumns().stream()
                .filter(column -> column.getPosition() == columnDto.position())
                .findFirst()
                .ifPresent(c -> {
                    throw new DoubleColumnPositionException("The board has already a column with position: " + columnDto.position());
                });

        Columnn entity = columnMapper.toEntity(columnDto);
        entity.setBoard(board);
        Columnn savedEntity = columnRepository.save(entity);

        return columnMapper.toCreatedDto(savedEntity);
    }

    @Override
    @Transactional
    public ColumnDto.Updated updateColumn(UUID id, ColumnDto.Update columnDto) {
        Columnn entity = columnRepository.findById(id).orElseThrow(() -> new NoSuchEntityExistsException("No column found with id: " + id));
        entity.setName(columnDto.name());

        Columnn updatedColumn = columnRepository.save(entity);
        return columnMapper.toUpdatedDto(updatedColumn);
    }

    @Override
    @Transactional
    public ColumnDto.GetById move(UUID id, ColumnDto.Move columnDto) {
        Columnn columnn = columnRepository.findById(id).orElseThrow(() -> new NoSuchEntityExistsException("No column found with id: " + id));
        Board assosiatedBoard = columnn.getBoard();
        List<Columnn> columns = assosiatedBoard.getColumns().stream()
                .sorted(Comparator.comparingInt(Columnn::getPosition))
                .collect(Collectors.toList());

        if (columnDto.position() >= columns.size()) {
            throw new ColumnPositionIsOutOfBoardSizeException("New column's position is out of the board size");
        }

        columns.removeIf(col -> col.getId().equals(id));

        int newPosition = Math.min(columns.size(), columnDto.position());
        columns.add(newPosition, columnn);

        for (int i = 0; i < columns.size(); i++) {
            columns.get(i).setPosition(i);
        }

        columnRepository.saveAll(columns);
        return columnMapper.toGetByIdDto(columnn);
    }

    @Override
    @DeleteMapping
    public void deleteColumn(UUID id) {
        columnRepository.deleteById(id);
    }
}
