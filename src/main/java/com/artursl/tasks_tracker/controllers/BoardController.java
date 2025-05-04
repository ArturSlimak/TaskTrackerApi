package com.artursl.tasks_tracker.controllers;


import com.artursl.tasks_tracker.domain.common.PagedResponse;
import com.artursl.tasks_tracker.domain.dtos.BoardDto;
import com.artursl.tasks_tracker.domain.entities.Board;
import com.artursl.tasks_tracker.mappers.BoardMapper;
import com.artursl.tasks_tracker.services.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/boards")
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
    public BoardDto.GetById getBoardById(@PathVariable UUID id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public ResponseEntity<BoardDto.GetById> createBoard(@RequestBody BoardDto.Create boardDto) {
        BoardDto.GetById createdBoard = boardService.createBoard(boardDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdBoard.id().toString()).build().toUri();
        return ResponseEntity.created(location).body(createdBoard);
    }
}
