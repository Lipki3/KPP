package com.example.lab1.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data")
public class MyException extends RuntimeException{
    public MyException(String message) {
        super(message);
    }
}