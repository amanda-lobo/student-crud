package com.generation.test.exceptions;

public class InvalidNoteException extends RuntimeException {
    public InvalidNoteException(String message) {
        super(message);
    }
}
