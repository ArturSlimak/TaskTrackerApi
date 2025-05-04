package com.artursl.tasks_tracker.controllers;

import com.artursl.tasks_tracker.domain.dtos.ColumnDto;
import com.artursl.tasks_tracker.services.ColumnService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Validated
public class ColumnController {
    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @PostMapping("boards/{id}/columns")
    public ResponseEntity<ColumnDto.GetById> createColumn(@PathVariable UUID id, @Valid @RequestBody ColumnDto.Create columnDto) {
        ColumnDto.GetById createdColumn = columnService.createColumn(id, columnDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdColumn.id()).build().toUri();
        return ResponseEntity.created(location).body(createdColumn);
    }

    @PutMapping("columns/{id}")
    public ResponseEntity<ColumnDto.GetById> updateColumn(@PathVariable UUID id, @Valid @RequestBody ColumnDto.Update columnDto) {
        return ResponseEntity.ok(columnService.updateColumn(id, columnDto));
    }

    @PatchMapping("columns/{id}/move")
    public ResponseEntity<ColumnDto.GetById> moveColumn(@PathVariable UUID id,@Valid @RequestBody ColumnDto.Move columnDto)
    {
        return ResponseEntity.ok(columnService.move(id, columnDto));
    }

    @DeleteMapping("columns/{id}")
    public ResponseEntity<Void> deleteColumn(@PathVariable UUID id) {
        columnService.deleteColumn(id);
        return ResponseEntity.noContent().build();
    }
}
