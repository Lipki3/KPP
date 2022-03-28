package com.example.lab1.Controller;
import com.example.lab1.Repository;

import com.example.lab1.App;
import com.example.lab1.Validations.InputValidation;
import com.example.lab1.Validations.Validation;
import org.springframework.web.bind.annotation.*;
import com.example.lab1.Calculate;
import java.util.concurrent.atomic.AtomicLong;



@RestController

public class MainController {
    private final AtomicLong counter = new AtomicLong();
    Repository rep = new Repository();
    @GetMapping("/app")
    public Results Get (
            @RequestParam(value = "iYear", required = true, defaultValue = "2022") int iYear,
            @RequestParam(value = "iMonth", required = true, defaultValue = "3") int iMonth,
            @RequestParam(value = "iDate", required = true, defaultValue = "28") int iDate)
    {
        int result = 0;
        result = Validation.optionsValidation(iYear, iMonth, iDate);
        Calculate obj = new Calculate(iYear,iMonth,iDate);
        return new Results(counter.incrementAndGet(), obj.calculate());
    }
    @GetMapping("/cache")
    public Results Enter (
            @RequestParam(value = "iYear", required = true) int iYear,
            @RequestParam(value = "iMonth", required = true) int iMonth,
            @RequestParam(value = "iDate", required = true) int iDate)
    {
        App This = new App(iYear, iMonth, iDate);
        return rep.addToMap(This,InputValidation.optionsValidation(counter.incrementAndGet(),This));
    }

}