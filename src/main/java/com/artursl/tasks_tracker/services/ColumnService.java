package com.artursl.tasks_tracker.services;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ColumnService {
    ColumnDto.GetById createColumn(UUID id, ColumnDto.Create columnDto);
    ColumnDto.GetById updateColumn(UUID id, ColumnDto.Update columnDto);
    ColumnDto.GetById move(UUID id, ColumnDto.Move columnDto);
    void deleteColumn(UUID id);
}
