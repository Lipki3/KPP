package com.example.lab1.Controller;
import com.example.lab1.validation.InputValidation;

public record Results(long id, String day) {
    @Override
    public long id() {
        return id;
    }

    public String day() {
        return day;
    }
}