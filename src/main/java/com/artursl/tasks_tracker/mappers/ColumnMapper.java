package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.dtos.ListResponse;
import com.artursl.tasks_tracker.domain.dtos.TaskDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import com.artursl.tasks_tracker.domain.entities.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnMapper extends CommonMappers  {
    Columnn toEntity(ColumnDto.Create columnDto);
    ColumnDto toDto(Columnn columnn);
    ColumnDto.GetById toGetByIdDto(Columnn columnn);
    ColumnDto.Updated toUpdatedDto(Columnn columnn);
    ColumnDto.Created toCreatedDto(Columnn columnn);

    default ListResponse<TaskDto.GetOverviewDto> mapTaskToListResponse(List<Task> tasks) {
        return mapListToListResponse(tasks, this::mapTaskToOverviewDto);
    }
    TaskDto.GetOverviewDto mapTaskToOverviewDto(Task task);
}
