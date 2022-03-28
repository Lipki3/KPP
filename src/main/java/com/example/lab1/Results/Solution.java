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
        int N1, N2, N3, N4, N5, N6, k;
        N4 =  parameters.getFirstValue();
        N5 =  parameters.getSecondValue();
        N6 =  parameters.getThirdValue();
      //  temp = parameters.getSecondValue() * parameters.getSecondValue()  * parameters.getFirstValue();
        if (N5 < 3) {
            // If January or February, adjust Month and Year
            N5 += 12;
            --N4;
        }

        N1 = (26 * (N5 + 1)) / 10;    // Month Shift
        N2 = (125 * N4) / 100;         // Leap Correction

        N3 = N6 + N1 + N2 - (N4 / 100) + (N4 / 400) - 1;


        k = N3 % 7;

        setRoot(k);
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