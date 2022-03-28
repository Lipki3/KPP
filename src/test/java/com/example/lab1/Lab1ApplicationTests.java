package com.example.lab1;

import com.example.lab1.Controller.MainController;
import com.example.lab1.Controller.Results;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class Lab1ApplicationTests {
    private final MainController test = new MainController();

   /* @Test
    void testCalculatePr() throws CustomException {
        Results a = test.simpleCalculation(14, 3, 2022);
        String day = "Monday";
        assertEquals(day, a.calculate(14, 3, 2022));
    }
    */


}