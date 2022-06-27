package com.example.tester2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("2","2");
        calc.setArithmeticOperator("+");
        assertEquals(calc.getResult(), "4");
    }

    @Test
    public void additionWithDouble_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("2","2.05");
        calc.setArithmeticOperator("+");
        assertEquals(calc.getResult(),"4.05");
    }

    @Test
    public void additionRoundsOnlyTwoDecimals() {
        Calculator calc = new Calculator();
        calc.setOperands("1","2.00000005");
        calc.setArithmeticOperator("+");
        assertEquals(calc.getResult(),"3");
    }

    @Test
    public void multiplcation_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("2","3");
        calc.setArithmeticOperator("*");
        assertEquals(calc.getResult(), "6");
    }

    @Test
    public void multiplcationWithDouble_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("2.5","3.5");
        calc.setArithmeticOperator("*");
        assertEquals(calc.getResult(), "8.75");
    }

    @Test
    public void multiplcationOnlyRoundsTwoDecimals() {
        Calculator calc = new Calculator();
        calc.setOperands("2.55","3.55");
        calc.setArithmeticOperator("*");
        assertEquals(calc.getResult(), "9.05");
    }

    @Test
    public void subtraction_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("2","3");
        calc.setArithmeticOperator("-");
        assertEquals(calc.getResult(), "-1");
    }

    @Test
    public void subtractionWithDouble_isCorrect(){
        Calculator calc = new Calculator();
        calc.setOperands("2","3.5");
        calc.setArithmeticOperator("-");
        assertEquals(calc.getResult(), "-1.5");
    }

    @Test
    public void subtractionOnlyRoundsTwoDecimal(){
        Calculator calc = new Calculator();
        calc.setOperands("2","3.0005");
        calc.setArithmeticOperator("-");
        assertEquals(calc.getResult(), "-1");
    }

    @Test
    public void division_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("6","3");
        calc.setArithmeticOperator("/");
        assertEquals(calc.getResult(), "2");
    }

    @Test
    public void divisionWithDouble_isCorrect() {
        Calculator calc = new Calculator();
        calc.setOperands("9","2.5");
        calc.setArithmeticOperator("/");
        assertEquals(calc.getResult(), "3.6");
    }

    @Test
    public void divisionOnlyRoundsTwoDecimal() {
        Calculator calc = new Calculator();
        calc.setOperands("10","6");
        calc.setArithmeticOperator("/");
        assertEquals(calc.getResult(), "1.67");
    }

    @Test
    public void cannotDivideZero() {
        Calculator calc = new Calculator();
        calc.setOperands("6","3");
        calc.setArithmeticOperator("/");
        assertEquals(calc.getResult(), "ERROR");
    }



}