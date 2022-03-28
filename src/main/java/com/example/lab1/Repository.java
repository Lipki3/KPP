package com.example.lab1;


import org.springframework.stereotype.Component;
import com.example.lab1.Controller.Results;
import java.util.HashMap;

@Component
public class Repository {
    private final HashMap<App, Results> hashMap = new HashMap<>();

    public boolean isContain(App key) {
        return hashMap.containsKey(key);
    }

    public Results addToMap(App key, Results result) {
        hashMap.put(key, result);
        return result;
    }

    public Results getParameters(App key) {

        return hashMap.get(key);
    }
}