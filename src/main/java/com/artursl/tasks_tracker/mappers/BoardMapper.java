package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BoardMapper {
    Board toEntity(BoardDto.Create boardDto);
    BoardDto.GetAll toGetAllDto(Board board);
    BoardDto.GetById toGetByIdDto(Board board);
}
