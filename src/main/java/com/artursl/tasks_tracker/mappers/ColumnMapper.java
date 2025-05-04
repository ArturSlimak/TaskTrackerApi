package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.domain.entities.Columnn;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ColumnMapper {
    Columnn toEntity(ColumnDto columnDto);
    ColumnDto toDto(Columnn columnn);
}
