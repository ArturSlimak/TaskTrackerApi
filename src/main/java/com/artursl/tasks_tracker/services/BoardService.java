package com.artursl.tasks_tracker.services;


import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    List<BoardDto> getAllBoards();
    BoardDto getBoardById(UUID id);
    BoardDto createBoard(BoardDto boardDto);
}
