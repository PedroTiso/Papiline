package br.inatel.cdg.service;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    @Test
    public void givenTwoIntegers_WhenMethodAdd_thenReturnTheirSum(){
        int sum = Calculator.add(1,2);
        assertEquals(3, sum);
    }

    @Test
    public void givenTwoIntegers_WhenMethodSubtract_thenReturnTheirDifference(){
        int diff = Calculator.sub(2,1);
        assertEquals(1, diff);
    }

    @Test
    public void givenTwoIntegers_WhenMethodMultiply_thenReturnTheirProduct(){
        int mult = Calculator.multiply(1,2);
        assertEquals(2, mult);
    }


}
