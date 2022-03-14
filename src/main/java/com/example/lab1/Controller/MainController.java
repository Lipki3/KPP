package com.example.lab1.Controller;

import com.example.lab1.Calculate;
import com.example.lab1.validation.InputValidation;
import com.example.lab1.exception.CustomException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/app")
    public Results simpleCalculation (@RequestParam(value = "iDate", required = true) int iDate,
                                  @RequestParam(value = "iMonth", required = true) int iMonth,
                                  @RequestParam(value = "iYear", required = true) int iYear) throws CustomException
    {
        int result = 0;
        result = InputValidation.optionsValidation(iYear, iMonth, iDate);
        Calculate obj = new Calculate(iYear,iMonth,iDate);
        return new Results(counter.incrementAndGet(), obj.calculate());
    }


}
/* public Results Enter(
            @RequestParam(value = "iDate", required = true) int iDate,
            @RequestParam(value = "iMonth", required = true) int iMonth,
            @RequestParam(value = "iYear", required = true) int iYear)
    {
        Calculate a = new Calculate(iYear,iMonth,iDate);
        return new Results(counter.incrementAndGet(), a.calculate());*/