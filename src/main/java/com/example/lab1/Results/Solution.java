package com.example.lab1.Results;

import com.example.lab1.SpringConfig;
import com.example.lab1.Cache.cache;
import com.example.lab1.logger.Logger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Solution {

    private final cache Cache;

    private final Parameters parameters;

    private Integer root;

    public Solution(Parameters params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cache = context.getBean("cache", cache.class);
        context.close();

        this.parameters = params;
    }

    public void calculateRoot() {
        // Trying to find root in cache
        var temp = Cache.find(parameters);
        if (temp != null) {
            Logger.log(Level.WARN, "Value found in cache!");
            setRoot(temp);

            return;
        }

        // If not found

        temp = parameters.getSecondValue() * parameters.getSecondValue()  * parameters.getFirstValue();
        setRoot(temp);
        // Adding { inputParams, root } to cache
        Cache.add(parameters, root);
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(@Nullable Integer root) {
        this.root = root;
    }

}