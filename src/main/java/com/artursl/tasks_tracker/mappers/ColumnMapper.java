package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ColumnMapper {
    Columnn toEntity(ColumnDto.Create columnDto);
    ColumnDto toDto(Columnn columnn);
    ColumnDto.GetById toGetByIdDto(Columnn columnn);
    ColumnDto.Updated toUpdatedDto(Columnn columnn);
    ColumnDto.Created toCreatedDto(Columnn columnn);

}
