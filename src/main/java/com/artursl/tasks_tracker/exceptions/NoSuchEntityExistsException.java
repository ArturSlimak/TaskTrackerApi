package com.artursl.tasks_tracker.exceptions;

public class NoSuchEntityExistsException extends RuntimeException  {
    public NoSuchEntityExistsException(String message) {
        super(message);
    }
}
