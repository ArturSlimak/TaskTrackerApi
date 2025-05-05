package com.artursl.tasks_tracker.exceptions;

public class NotTheSameBoardException extends RuntimeException {
    public NotTheSameBoardException(String message) {
        super(message);
    }
}
