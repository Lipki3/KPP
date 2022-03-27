package com.example.lab1.solutions;

public class Calculate {

    private int iYear;
    private int iMonth;
    private int iDate;

    public Calculate(int iYear, int iMonth, int iDate) {
        this.iYear = iYear;
        this.iMonth = iMonth;
        this.iDate = iDate;
    }

    public String calculate() {

        // Month:  March   -  3 ... December - 12 of Current  Year
        //         January - 13,    February - 14 of Previous Year
        if (iMonth < 3) {
            // If January or February, adjust Month and Year
            iMonth += 12;
            --iYear;
        }

        int N1 = (26 * (iMonth + 1)) / 10;    // Month Shift
        int N2 = (125 * iYear) / 100;         // Leap Correction

        int N3 = iDate + N1 + N2 - (iYear / 100) + (iYear / 400) - 1;

        int k = 0;
        k = N3 % 7;

        if (k == 1) return "Monday";
        if (k == 2) return "Tuesday";
        if (k == 3) return "Wednesday";
        if (k == 4) return "Thursday";
        if (k == 5) return "Friday";
        if (k == 6) return "Saturday";
        if (k == 0) return "Sunday";

        return "error";
    }
}


