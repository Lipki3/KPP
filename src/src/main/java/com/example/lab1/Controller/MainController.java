package com.example.lab1.Controller;

import com.example.lab1.Validations.Results;
import com.example.lab1.logger.Logger;
import com.example.lab1.Repository;
import com.example.lab1.Cache.cache;
import com.example.lab1.App;
import com.example.lab1.Results.Solution;
import com.example.lab1.Validations.InputValidation;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.example.lab1.Stats.Statistics;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MainController {

    private final AtomicLong counter = new AtomicLong();
    RequestCounterController NumberOfRequests = new RequestCounterController();
    Repository rep = new Repository();
    @GetMapping("/app")
    public Results Enter (
            @RequestParam(value = "year", required = true, defaultValue = "2022") int iYear,
            @RequestParam(value = "month", required = true, defaultValue = "4") int iMonth,
            @RequestParam(value = "date", required = true, defaultValue = "5") int iDate)
    {
        NumberOfRequests.IncremetNumber();
        App ThisDay = new App(iYear, iMonth, iDate);
        Logger.log(Level.INFO,  "Successfully getMapping");
        if(rep.isContain(ThisDay)) {
            var b = new Solution(ThisDay);
            b.calculateRoot();
            Logger.log(Level.INFO,  "This date is already in the cache");
            return rep.getParameters(ThisDay);
        }
        else {
            var b = new Solution(ThisDay);
            b.calculateRoot();
            Logger.log(Level.INFO,  "This date is added in the cache");
            return rep.addToMap(ThisDay,InputValidation.optionsValidation(counter.incrementAndGet(),ThisDay));
        }
    }


    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(cache.getStaticStringCache(), HttpStatus.OK);
    }

    @PostMapping("/stream")
    public ResponseEntity<?> EnterStream(@Valid @RequestBody List<App> bodyList){

        NumberOfRequests.IncremetNumber();
        List<Results> resultList = new LinkedList<>();
        bodyList.forEach((currentElement) -> {
            try {
                resultList.add(InputValidation.optionsValidation(counter.incrementAndGet(),currentElement));
            } catch (IllegalArgumentException e) {
                Logger.log(Level.INFO,  "Error postMapping");
            }
        });
    
        Logger.log(Level.INFO,  "Successfully postMapping");
        double Mondays = Statistics.findMondays(resultList);
        double Sundays = Statistics.findSundays(resultList);
        return new ResponseEntity<>(resultList  + "\nMondays: " +
                Mondays + "\nSundays: " + Sundays, HttpStatus.OK);

    }
}
