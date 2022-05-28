package com.example.lab1.Stats;

import com.example.lab1.DataClass;
import com.example.lab1.Validations.Results;

import java.util.List;

public class Statistics {
    public int stats;
    public Statistics() {};
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


    static public int findDecember(List<DataClass> resultList) {
        int december = 0;
        for (int i = 0; i<10;) {
            if(resultList.get(i).getMonth() == 12)
            {
              december++;
            }
            i++;
        }
        return december;
    }

    static public int findJanuary(List<DataClass> resultList) {
        int january = 0;
        for (int i = 0; i<10;) {
            if(resultList.get(i).getMonth() == 1)
            {
                january++;
            }
            i++;
        }
        return january;
    }

    static public String Day(DataClass el) {
       String result = "";
        int N1, N2, N3, k;
        if (el.getMonth() < 3) {
            // If January or February, adjust Month and Year
            int N4 = el.getMonth() + 12; // iMonth
            int N5 = el.getYear() - 1; // iYear
            N1 = (26 * (N4 + 1)) / 10;    // Month Shift
            N2 = (125 * N5 / 100);         // Leap Correction

            N3 = el.getDate() + N1 + N2 - (N5 / 100) + (N5 / 400) - 1;
            k = 0;
            k = N3 % 7;
        } else {

            N1 = (26 * (el.getMonth() + 1)) / 10;    // Month Shift
            N2 = (125 * el.getYear() / 100);         // Leap Correction

            N3 = el.getDate() + N1 + N2 - (el.getYear() / 100) + (el.getYear() / 400) - 1;

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

    public long calcSize(List<DataClass> resList){
        long size =0;
        if(!resList.isEmpty()){
            size = resList.stream().count();
        }
        return size;
    }
}