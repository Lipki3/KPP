package com.example.lab1.Stats;

import com.example.lab1.Validations.Results;

import java.util.List;

public class Statistics {

    static public double findMondays(List<Results> resultList) {
        int monday = 0;
        int i=0;
        for (Results a : resultList) {
            if(resultList.get(i).iDay() == "Monday");
            {
              monday++;
            }
            i++;
        }
        return monday;
    }

    static public double findSundays(List<Results> resultList) {
        int sunday = 0;
        int i=0;
        for (Results a : resultList) {
            if(resultList.get(i).iDay() == "Sundays");
            {
               sunday++;
            }
            i++;
        }
        return sunday;
    }
}