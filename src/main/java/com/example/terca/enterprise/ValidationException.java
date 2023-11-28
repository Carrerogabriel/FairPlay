package com.example.terca.enterprise;

public class ValidationException extends  RuntimeException{
    public  ValidationException(String mensagem) {
        super(mensagem);
    }
}
