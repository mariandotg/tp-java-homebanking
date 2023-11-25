package com.example.tpjavahomebanking.exceptions;

public class UserNotExistsException extends RuntimeException{

    public UserNotExistsException(String message){
        super(message);
    }
}
