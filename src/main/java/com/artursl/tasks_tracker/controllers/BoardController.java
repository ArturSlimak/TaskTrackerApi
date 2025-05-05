package com.artursl.tasks_tracker.controllers;


import com.artursl.tasks_tracker.domain.common.PagedResponse;
import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.services.BoardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/boards")
@Validated
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<PagedResponse<BoardDto.GetAll>> getAllBoards(@RequestParam(defaultValue = "1") int page,
                                                                       @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(boardService.getAllBoards(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto.GetById> getBoardById(@PathVariable UUID id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    @PostMapping
    public ResponseEntity<BoardDto.GetById> createBoard(@Valid @RequestBody BoardDto.Create boardDto) {
        BoardDto.GetById createdBoard = boardService.createBoard(boardDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdBoard.id().toString()).build().toUri();
        return ResponseEntity.created(location).body(createdBoard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto.GetById> updateBoard(@PathVariable UUID id, @Valid @RequestBody BoardDto.Update boardDto) {
        return ResponseEntity.ok(boardService.updateBoard(id, boardDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable UUID id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
