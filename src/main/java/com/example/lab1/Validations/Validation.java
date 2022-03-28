package com.example.lab1.Validations;

import com.example.lab1.Exceptions.MyException;

public class Validation {

    public static boolean isInt(int s) {
        try {
            if (s > 0) return true;
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static int optionsValidation(int iYear, int iMonth, int iDate) {
        int sum = 0;
        if ( (isInt(iYear)) && iYear > 1900 && iYear < 2100 ) {
            sum  += 1;
        } else {
            throw new MyException("BAD REQUEST ERROR 400: Year is invalid");
        }

        if ( (isInt(iMonth)) && iMonth > 0 && iMonth < 13 ) {
            sum  += 1;
        } else {
            throw new MyException("BAD REQUEST ERROR 400: Month is invalid");
        }

        if (iMonth == 2) {
            if ((isInt(iDate)) && iDate > 0 && iDate < 30) {
                sum += 1;
            } else {
                throw new MyException("BAD REQUEST ERROR 400: Date is invalid");
            }
        }

        if (iMonth == 1 || iMonth == 3 || iMonth == 5|| iMonth == 7|| iMonth == 8|| iMonth == 10|| iMonth == 12) {
            if ((isInt(iDate)) && iDate > 0 && iDate < 32) {
                sum += 1;
            } else {
                throw new MyException("BAD REQUEST ERROR 400: Date is invalid");
            }
        }

        if (iMonth == 2 || iMonth == 4 || iMonth == 6|| iMonth == 9|| iMonth == 11) {
            if ((isInt(iDate)) && iDate > 0 && iDate < 31) {
                sum += 1;
            } else {
                throw new MyException("BAD REQUEST ERROR 400: Date is invalid");
            }
        }

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
        if (k==0) k =7;
        return k;
    }


}