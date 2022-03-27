package com.example.lab1.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.lab1.validation.InputValidation;
import java.util.concurrent.atomic.AtomicLong;
import com.example.lab1.solutions.Calculate;
import com.example.lab1.exception.CustomException;
import com.example.lab1.cache.Cache;
import com.example.lab1.solutions.Parameters;
import com.example.lab1.solutions.Solution;


@RestController

public class MainController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping(value = "/app")
   // public ResponseEntity<Object> simpleCalculation (@RequestParam(value = "iYear", required = true) int iYear,
    public Results simpleCalculation (@RequestParam(value = "iYear", required = true) int iYear,
                                             @RequestParam(value = "iMonth", required = true) int iMonth,
                                             @RequestParam(value = "iDate", required = true) int iDate) throws  CustomException {
        if (iYear < 1900 || iYear > 2100)
            throw new CustomException("ERROR 400, BAD REQUEST, invalid Year...");
        if (iMonth < 1 || iMonth > 12)
            throw new CustomException("ERROR 400, BAD REQUEST, invalid Month...");
        if (iDate < 1 || iDate > 31)
            throw new CustomException("ERROR 400, BAD REQUEST, invalid Date...");

       // var solution = new Solution(new Parameters(iYear,iMonth,iDate));
        //solution.calculateRoot();

        //return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);

        int result = 0;
        result = InputValidation.optionsValidation(iYear, iMonth, iDate);
        Calculate obj = new Calculate(iYear,iMonth,iDate);
        return new Results(counter.incrementAndGet(), obj.calculate());
    }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(Cache.getStaticStringCache(), HttpStatus.OK);
    }


}
