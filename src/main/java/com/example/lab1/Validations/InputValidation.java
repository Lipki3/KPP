package com.example.lab1.Validations;

import com.example.lab1.Exceptions.MyException;
import com.example.lab1.App;
import com.example.lab1.Controller.Results;
public class InputValidation {


    public String calculate(int iYear, int iMonth, int iDate) {

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


    public static boolean isInt(int s) {
        try {
            if (s > 0) return true;
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static Results optionsValidation(long id, App a) {

        if ( (isInt(a.iYear())) || a.iYear() < 1900 || a.iYear() >2100) {

        } else {
            throw new MyException("BAD REQUEST ERROR 400: Year is invalid");
        }

        if ( (isInt(a.iMonth())) || a.iMonth() <1 || a.iMonth() >12) {

        } else {
            throw new MyException("BAD REQUEST ERROR 400: Month is invalid");
        }

        if ((isInt(a.iDate())) || a.iDate() <1 || a.iDate() >31 ){

        } else {
            throw new MyException("BAD REQUEST ERROR 400: Date is invalid");
        }

        // String result;
        int N1, N2, N3, k;
        if (a.iMonth() < 3) {
            // If January or February, adjust Month and Year
            int N4 = a.iMonth() + 12; // iMonth
            int N5 = a.iYear() - 1; // iYear
            N1 = (26 * (N4 + 1)) / 10;    // Month Shift
            N2 = (125 * N5 / 100);         // Leap Correction

            N3 = a.iDate() + N1 + N2 - (N5 / 100) + (N5 / 400) - 1;
            k = 0;
            k = N3 % 7;
        } else {

            N1 = (26 * (a.iMonth() + 1)) / 10;    // Month Shift
            N2 = (125 * a.iYear() / 100);         // Leap Correction

            N3 = a.iDate() + N1 + N2 - (a.iYear() / 100) + (a.iYear() / 400) - 1;

            k = 0;
            k = N3 % 7;
        }
        //  if (k == 1) result = "Monday";
        //f (k == 2) result =  "Tuesday";
        //  if (k == 3) result =  "Wednesday";
        //  if (k == 4) result =  "Thursday";
        //  if (k == 5) result =  "Friday";
        // if (k == 6) result =  "Saturday";
        //  if (k == 0) result =  "Sunday";

        return new Results(id,k);
    }



}