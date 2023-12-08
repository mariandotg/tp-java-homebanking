package com.example.tpjavahomebanking.exceptions;

public class InsufficientFoundsException extends RuntimeException {
    public InsufficientFoundsException(String message) {
        super(message);
    }
}
