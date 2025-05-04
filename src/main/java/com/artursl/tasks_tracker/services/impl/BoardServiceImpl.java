package com.artursl.tasks_tracker.services.impl;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.mappers.BoardMapper;
import com.artursl.tasks_tracker.repositories.BoardRepository;
import com.artursl.tasks_tracker.services.BoardService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;


    public BoardServiceImpl(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto.GetAll> getAllBoards() {
        return boardRepository.findAll()
                .stream().map(boardMapper::toGetAllDto).collect(Collectors.toList());
    }

    @Override
    public BoardDto.GetById getBoardById(UUID id) {
        return boardMapper.toGetByIdDto(boardRepository.findById(id).orElse(null));
    }

    @Override
    public BoardDto.GetById createBoard(BoardDto.Create boardDto) {
        Board entity = boardMapper.toEntity(boardDto);
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
        Board savedEntity = boardRepository.save(entity);
        return boardMapper.toGetByIdDto(savedEntity);
    }
}
