package com.example.lab1.Controller;

public record Results(long id,  String iDay) {
    @Override
    public long id() {
        return id;
    }

    @Override
    public String iDay() {
        return iDay;
    }
}

