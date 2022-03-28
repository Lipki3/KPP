package com.example.lab1.Controller;

import com.example.lab1.Exceptions.BadRequestException;
import com.example.lab1.Exceptions.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.lab1.Results.Parameters;
import com.example.lab1.Results.Solution;
import com.example.lab1.Cache.cache;

@RestController
public class MainController {
    @GetMapping(value = "/app")
    public ResponseEntity<Object> calculate (@RequestParam(value = "iYear", defaultValue = "0") int iYear,
                                             @RequestParam(value = "iMonth", defaultValue = "0") int iMonth,
                                             @RequestParam(value = "iDate", defaultValue = "0") int iDate) throws  MyException {

        if (iYear < 1900 || iYear >2100)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid Year...");
        if (iMonth < 0 || iMonth >12)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid Month...");
        if (iDate < 0 || iDate >31)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid Date...");

        var solution = new Solution(new Parameters(iYear,iMonth, iDate));
        solution.calculateRoot();

        return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(cache.getStaticStringCache(), HttpStatus.OK);
    }
}