package com.example.tpjavahomebanking.exceptions;

public class TransferNotFoundException extends RuntimeException{
    public TransferNotFoundException(String message) {
        super(message);
    }
}