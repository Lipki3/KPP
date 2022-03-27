package com.example.lab1.solutions;


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
    public Integer getThirdValueValue() {
        assert thirdValue != null;
        return thirdValue;
    }

    public Integer calc(int thirdValue, int secondValue, int firstValue) {

        // Month:  March   -  3 ... December - 12 of Current  Year
        //         January - 13,    February - 14 of Previous Year
        if (secondValue < 3) {
            // If January or February, adjust Month and Year
            secondValue += 12;
            --firstValue;
        }

        int N1 = (26 * (secondValue + 1)) / 10;    // Month Shift
        int N2 = (125 * firstValue) / 100;         // Leap Correction

        int N3 = thirdValue + N1 + N2 - (firstValue / 100) + (firstValue / 400) - 1;

        int k = 0;
        k = N3 % 7;


        return 0;
    }



    public void setFirstValue(@Nullable Integer firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(@Nullable Integer secondValue) {
        this.secondValue = secondValue;
    }

    public void setThirdValueValue(@Nullable Integer thirdValue) {
        this.thirdValue = thirdValue;
    }

}

