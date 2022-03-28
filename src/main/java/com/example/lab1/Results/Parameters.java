package com.example.lab1.Results;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import java.util.Objects;

public class Parameters {

    // Method hashCode() overriding
    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue, thirdValue);
    }

    private @Nullable Integer firstValue;

    private @Nullable Integer secondValue;

    private @Nullable Integer thirdValue;

    public Parameters(
            @Nullable Integer firstValue,
            @Nullable Integer secondValue,
            @Nullable Integer thirdValue
    ) {

        if (firstValue == null)
            throw new IllegalArgumentException("No first value!");

        if (secondValue == null)
            throw new IllegalArgumentException("No second value!");

        if (thirdValue == null)
            throw new IllegalArgumentException("No third value!");

        this.firstValue  = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getFirstValue() {
        assert firstValue != null;
        return firstValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getSecondValue() {
        assert secondValue != null;
        return secondValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getThirdValue() {
        assert thirdValue != null;
        return thirdValue;
    }




    public void setFirstValue(@Nullable Integer firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(@Nullable Integer secondValue) {
        this.secondValue = secondValue;
    }

    public void setThirdValue(@Nullable Integer thirdValue) {
        this.thirdValue = thirdValue;
    }
}