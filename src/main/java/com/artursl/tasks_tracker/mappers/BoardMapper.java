package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import org.mapstruct.Mapper;

@Mapper
public interface BoardMapper {
    Board toModel(BoardDto boardDto);
    BoardDto toDto(Board board);
}
