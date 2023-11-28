package com.example.terca.service.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException (String msg){
        super(msg);
    }
}
