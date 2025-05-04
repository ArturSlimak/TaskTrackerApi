package com.artursl.tasks_tracker.services;


import com.artursl.tasks_tracker.domain.common.PagedResponse;
import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    PagedResponse<BoardDto.GetAll> getAllBoards(int page, int size);
    BoardDto.GetById getBoardById(UUID id);
    BoardDto.GetById createBoard(BoardDto.Create boardDto);
    BoardDto.GetById updateBoard(UUID id, BoardDto.Update boardDto);
}
