package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.dtos.ListResponse;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface BoardMapper {
    Board toEntity(BoardDto.Create boardDto);

    BoardDto.GetAll toGetAllDto(Board board);

    BoardDto.GetById toGetByIdDto(Board board);

    default ListResponse<ColumnDto.GetById> mapColumnToListResponse(List<Columnn> columns) {
        if (columns == null) return new ListResponse<>(List.of());
        var items = columns.stream().map(this::mapColumnToDto).collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    ColumnDto.GetById mapColumnToDto(Columnn column);
}
