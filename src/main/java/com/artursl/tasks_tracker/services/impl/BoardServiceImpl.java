package com.artursl.tasks_tracker.services.impl;

import com.artursl.tasks_tracker.domain.common.PagedResponse;
import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.exceptions.NoSuchEntityExistsException;
import com.artursl.tasks_tracker.mappers.BoardMapper;
import com.artursl.tasks_tracker.repositories.BoardRepository;
import com.artursl.tasks_tracker.services.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public PagedResponse<BoardDto.GetAll> getAllBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Board> boardPage = boardRepository.findAll(pageable);

        List<BoardDto.GetAll> items = boardPage.getContent()
                .stream().map(boardMapper::toGetAllDto).toList();
        return new PagedResponse<>(
                items,
                boardPage.getNumber() + 1,
                boardPage.getSize(),
                items.size(),
                boardPage.getTotalElements(),
                boardPage.getTotalPages()
        );
    }

    @Override
    public BoardDto.GetById getBoardById(UUID id) {
        //TODO
        //filter unassignedTask
        BoardDto.GetById board = boardMapper.toGetByIdDto(boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityExistsException("No board found with id: " + id)));
        board.columns().sort(Comparator.comparingInt(ColumnDto.GetById::position));
        return board;
    }

    @Override
    @Transactional
    public BoardDto.GetById createBoard(BoardDto.Create boardDto) {
        Board entity = boardMapper.toEntity(boardDto);
        Board savedEntity = boardRepository.save(entity);
        return boardMapper.toGetByIdDto(savedEntity);
    }

    @Override
    @Transactional
    public BoardDto.GetById updateBoard(UUID id, BoardDto.Update boardDto) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityExistsException("No board found with id: " + id));

        board.setName(boardDto.name());
        Board updatedEntity = boardRepository.save(board);
        return boardMapper.toGetByIdDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteBoard(UUID id) {
        boardRepository.deleteById(id);
    }
}
