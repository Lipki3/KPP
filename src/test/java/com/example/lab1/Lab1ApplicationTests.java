package com.example.lab1;
import com.example.lab1.Controller.MainController;
import com.example.lab1.Exceptions.MyException;
import com.example.lab1.Validations.Results;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab1ApplicationTests  {
    private final MainController test = new MainController();

    @Test
    void testCalculate() throws MyException {
        Results a = test.Enter(2022, 4, 4);
        String Day = "Monday";
        assertEquals(Day, a.iDay());
    }

}