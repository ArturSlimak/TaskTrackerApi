package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import org.mapstruct.Mapper;

@Mapper
public interface ColumnMapper {
    Columnn toModel(ColumnDto columnDto);
    ColumnDto toDto(Columnn columnn);
}
