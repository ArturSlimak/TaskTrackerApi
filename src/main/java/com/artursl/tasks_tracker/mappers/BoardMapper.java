package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.dtos.ListResponse;
import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BoardMapper extends CommonMappers {
    Board toEntity(BoardDto.Create boardDto);
    BoardDto.GetAll toGetAllDto(Board board);
    BoardDto.GetById toGetByIdDto(Board board);
    BoardDto.Updated toUpdatedDto(Board board);
    BoardDto.Created toCreatedDto(Board board);

    default ListResponse<ColumnDto.GetById> mapColumnToListResponse(List<Columnn> columns) {
        return mapListToListResponse(columns, this::mapColumnToDto);
    }

    default ListResponse<TaskDto.GetById> mapTaskToListResponse(List<Task> tasks) {
        return mapListToListResponse(tasks, this::mapTaskToDto);
    }

    ColumnDto.GetById mapColumnToDto(Columnn column);
    TaskDto.GetById mapTaskToDto(Task task);
}
