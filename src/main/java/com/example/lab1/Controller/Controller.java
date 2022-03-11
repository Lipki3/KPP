package com.example.lab1.Controller;

public record Controller(long id, String day) {
    @Override
    public long id() {
        return id;
    }

    @Override
    public String day() {
        return day;
    }

}