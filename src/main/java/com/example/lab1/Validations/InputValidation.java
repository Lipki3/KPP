package com.example.lab1.Validations;

import com.example.lab1.Exceptions.MyException;
import com.example.lab1.App;

public class InputValidation {

    public static Results optionsValidation(long id, App a) {

        if (a.iYear() < 1900 || a.iYear() >2100)
            throw new MyException("BAD REQUEST ERROR 400: Year is invalid");


        if (a.iMonth() <1 || a.iMonth() >12)
            throw new MyException("BAD REQUEST ERROR 400: Month is invalid");


        if (a.iDate() <1 || a.iDate() >31 )
            throw new MyException("BAD REQUEST ERROR 400: Date is invalid");


        String result = "error";
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
          if (k == 1) result = "Monday";
        if (k == 2) result =  "Tuesday";
          if (k == 3) result =  "Wednesday";
          if (k == 4) result =  "Thursday";
          if (k == 5) result =  "Friday";
        if (k == 6) result =  "Saturday";
          if (k == 0) result =  "Sunday";


        return new Results(id, result);
    }



}






















