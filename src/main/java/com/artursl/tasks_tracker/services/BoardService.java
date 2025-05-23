package com.artursl.tasks_tracker.services;

import com.artursl.tasks_tracker.domain.common.PagedResponse;
import com.artursl.tasks_tracker.domain.dtos.BoardDto;

import java.util.UUID;

public interface BoardService {
    PagedResponse<BoardDto.GetAll> getAllBoards(int page, int size);
    BoardDto.GetById getBoardById(UUID id);
    BoardDto.Created createBoard(BoardDto.Create boardDto);
    BoardDto.Updated updateBoard(UUID id, BoardDto.Update boardDto);
    void deleteBoard(UUID id);
}
