package com.artursl.tasks_tracker.exceptions;

public class NoSuchEntityExistsException extends RuntimeException  {
    private String message;

    public NoSuchEntityExistsException() {
    }

    public NoSuchEntityExistsException(String message) {
        super(message);
        this.message = message;
    }
}
