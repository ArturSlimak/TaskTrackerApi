package com.artursl.tasks_tracker.services;


import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    List<BoardDto.GetAll> getAllBoards();
    BoardDto.GetById getBoardById(UUID id);
    BoardDto.GetById createBoard(BoardDto.Create boardDto);
}
