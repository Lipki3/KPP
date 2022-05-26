package com.example.lab1;

public record App(int iYear, int iMonth, int iDate) {

    public int getFirstValue() { return iYear;}
    public int getSecondValue(){return iMonth;}
    public int getThirdValue(){return iDate;}
}