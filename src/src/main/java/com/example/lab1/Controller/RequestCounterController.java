package com.example.lab1.Controller;


import com.example.lab1.logger.Logger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestCounterController {
    static int NumberOfRequests = 0;
    synchronized public void IncremetNumber(){
        NumberOfRequests++;
        Logger.log(Level.INFO,  "Counter increment");
    }

    @GetMapping(value = "/counter")
    synchronized public String getCounter() {
        Logger.log(Level.INFO,  "Successfully getMapping");
        return "Number of requests: " + NumberOfRequests;
    }
}