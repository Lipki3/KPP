package com.example.lab1.Stats;

import com.example.lab1.Validations.Results;

import java.util.List;

public class Statistics {

    static public String post(int[] arr){
        int iYear = arr[0];
        int iMonth = arr[1];
        int iDate = arr[2];
        String result = "error";
        int N1, N2, N3, k;
        if (iMonth < 3) {
            // If January or February, adjust Month and Year
            int N4 = iMonth + 12; // iMonth
            int N5 = iYear - 1; // iYear
            N1 = (26 * (N4 + 1)) / 10;    // Month Shift
            N2 = (125 * N5 / 100);         // Leap Correction

            N3 = iDate + N1 + N2 - (N5 / 100) + (N5 / 400) - 1;
            k = 0;
            k = N3 % 7;
        } else {

            N1 = (26 * (iMonth + 1)) / 10;    // Month Shift
            N2 = (125 * iYear / 100);         // Leap Correction

            N3 = iDate + N1 + N2 - (iYear / 100) + (iYear / 400) - 1;

            k = 0;
            k = N3 % 7;
        }
        if (k == 1) result = "Monday";
        if (k == 2) result =  "Tuesday";
        if (k == 3) result =  "Wednesday";
        if (k == 4) result =  "Thursday";
        if (k == 5) result =  "Friday";
        if (k == 6) result =  "Saturday";
        if (k == 0) result =  "Sunday";

        return result;
    }
}