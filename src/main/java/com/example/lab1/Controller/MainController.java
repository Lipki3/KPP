package com.example.lab1.Controller;

import com.example.lab1.Calculate;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MainController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/app")
    public Results Enter(
            @RequestParam(value = "iDate", required = true) int iDate,
            @RequestParam(value = "iMonth", required = true) int iMonth,
            @RequestParam(value = "iYear", required = true) int iYear)
    {
        Calculate a = new Calculate(iYear,iMonth,iDate);
        return new Results(counter.incrementAndGet(), a.calculate());
    }


}