package com.example.lab1.Cache;

import com.example.lab1.Results.Parameters;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.example.lab1.logger.Logger;
import java.util.HashMap;
import java.util.Map;

public class cache {

    private static final Map<Parameters, Integer> solutions = new HashMap<>();

    public void add(@NotNull Parameters params, @NotNull Integer root) {
        if (!solutions.containsKey(params)) {
            solutions.put(params, root);
            Logger.log(Level.INFO, "Value " + params + "@" + root + " added to cache!");
        }
    }

    public @Nullable Integer find(@NotNull Parameters params) {
        if (solutions.containsKey(params))
            return solutions.get(params);

        Logger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

    @Contract(pure = true)
    public @NotNull String getStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public static @NotNull String getStaticStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public Map<Parameters, Integer> getSolutions() {
        return solutions;
    }
}