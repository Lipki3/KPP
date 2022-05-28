package com.example.lab1;

public class DataClass {

    public final int iYear;
    public final int iMonth;
    public final int iDate;

        public DataClass(int year, int month, int date){
            this.iYear = year;
            this.iMonth = month;
            this.iDate = date;
        }

        public int getMonth() {
             return iMonth;
        }
        public int getYear() {
        return iYear;
    }
        public int getDate() {
        return iDate;
    }

}
