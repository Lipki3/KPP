package com.example.lab1.Controller;

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

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong num = new AtomicLong();
    Repository rep = new Repository();
    @GetMapping("/app")
    public Results Enter (
            @RequestParam(value = "year", required = true, defaultValue = "2022") int iYear,
            @RequestParam(value = "month", required = true, defaultValue = "4") int iMonth,
            @RequestParam(value = "date", required = true, defaultValue = "5") int iDate)
    {
        num.incrementAndGet();
        App ThisDay = new App(iYear, iMonth, iDate);
        if(rep.isContain(ThisDay)) {
            var b = new Solution(ThisDay);
            b.calculateRoot();
            Logger.log(Level.INFO,  "This Triangle is already in the cache");
            return rep.getParameters(ThisDay);
        }
        else {
            var b = new Solution(ThisDay);
            b.calculateRoot();
            Logger.log(Level.INFO,  "This Triangle is added in the cache");
            return rep.addToMap(ThisDay,InputValidation.optionsValidation(counter.incrementAndGet(),ThisDay));
        }
    }


    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(cache.getStaticStringCache(), HttpStatus.OK);
    }
}
