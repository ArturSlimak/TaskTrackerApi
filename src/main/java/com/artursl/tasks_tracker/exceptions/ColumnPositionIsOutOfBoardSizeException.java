package com.artursl.tasks_tracker.exceptions;

public class ColumnPositionIsOutOfBoardSizeException extends RuntimeException {
    public ColumnPositionIsOutOfBoardSizeException(String message) {
        super(message);
    }
}
