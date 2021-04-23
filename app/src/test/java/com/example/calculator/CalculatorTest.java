package com.example.calculator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)

public class CalculatorTest {
    private Calculator mCalculator;

    @Before
    public void setUp(){
        mCalculator = new Calculator();
    }

    @Test
    public void getSqrNegative(){
        String result = mCalculator.getSqr("-9");
        assertThat(result, is(equalTo("NaN")));
    }

    @Test
    public void addTwoNumbers(){
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersDouble(){
        double resultAdd = mCalculator.add(1.111d, 1.111d);
        assertThat(resultAdd, is(equalTo(2.222d)));
    }

    @Test
    public void addTwoBigDouble(){
        double resultAdd = mCalculator.add(1.1111111111d, 2.2222222222d);
        assertThat(resultAdd, is(equalTo(3.3333333333d)));
    }

    @Test
    public void subTwoNumbers(){
        double resultSub = mCalculator.sub(3d, 2d);
        assertThat(resultSub, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double resultSub = mCalculator.sub(1d, 7d);
        assertThat(resultSub, is(equalTo(-6d)));
    }

    @Test
    public void mulTwoBigDouble(){
        double resultAdd = mCalculator.mul(9.9999999999d, 9.9999999999d);
        assertThat(resultAdd, is(equalTo(99.999999998d)));
    }

    @Test
    public void mulTwoNumbers(){
        double resultMul = mCalculator.mul(2d, 5d);
        assertThat(resultMul, is(equalTo(10d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double resultMul = mCalculator.mul(2d, 0d);
        assertThat(resultMul, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers(){
        double resultDiv = mCalculator.div(8d, 2d);
        assertThat(resultDiv, is(equalTo(4d)));
    }

    @Test
    public void divTwoDouble(){
        double resultDiv = mCalculator.div(0.0625d, 5d);
        assertThat(resultDiv, is(equalTo(0.0125d)));
    }

    @Test
    public void divTwoNumbersZero(){
        double resultDiv = mCalculator.div(3d, 0d);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void countStringBase1(){
        mCalculator.stringInput = "1+3";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("4")));
    }

    @Test
    public void countStringBase2(){
        mCalculator.stringInput = "10-9+2";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("3")));
    }

    @Test
    public void countStringBase3(){
        mCalculator.stringInput = "10-9.1+2";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2.9")));
    }

    @Test
    public void countStringBase4(){
        mCalculator.stringInput = "5+4-6+2+10-9";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("6")));
    }

    @Test
    public void countStringBase5(){
        mCalculator.stringInput = "5+4-6÷0+10-9";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("INFINITY")));
    }

    @Test
    public void countStringBase6(){
        mCalculator.stringInput = "0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("1")));
    }

    @Test
    public void countForStringWithBracket1(){
        mCalculator.stringInput = "(-1+3";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2")));
    }

    @Test
    public void countForStringWithBracket2(){
        mCalculator.stringInput = "(-1+3)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2")));
    }

    @Test
    public void countForStringWithBracket3(){
        mCalculator.stringInput = "4×(-7";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-28")));
    }

    @Test
    public void countForStringWithBracket4(){
        mCalculator.stringInput = "(-4+5×2)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("6")));
    }

    @Test
    public void countForStringWithBracket5(){
        mCalculator.stringInput = "((-4+5)×2";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2")));
    }

    @Test
    public void countForStringWithBracket6(){
        mCalculator.stringInput = "(-7+5)×(2+3)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-10")));
    }

    @Test
    public void countForStringWithBracket7(){
        mCalculator.stringInput = "(7-2)×(2+(-3))-100÷(18+2)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-10")));
    }

    @Test
    public void countForStringWithBracket8(){
        mCalculator.stringInput = "(7-2)×(2+(-3))";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-5")));
    }

    @Test
    public void countForStringWithBracket9(){
        mCalculator.stringInput = "(-4.0)+2";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-2")));
    }

    @Test
    public void countStringWithSqrt1(){
        mCalculator.stringInput = "10-√(81)+2";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("3")));
    }

    @Test
    public void countStringWithSqrt2(){
        mCalculator.stringInput = "10-√(81)×2+√(4)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("-6")));
    }

    @Test
    public void countStringWithSqrt3(){
        mCalculator.stringInput = "√(9)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("3")));
    }

    @Test
    public void countStringWithSqrt4(){
        mCalculator.stringInput = "√(4";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2")));
    }

    @Test
    public void countStringWithSqrt5(){
        mCalculator.stringInput = "√(√(81))";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("3")));
    }

    @Test
    public void countStringWithSqrt6(){
        mCalculator.stringInput = "√(√81)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("3")));
    }

    @Test
    public void countStringWithSqrt7(){
        mCalculator.stringInput = "√4";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("2")));
    }

    @Test
    public void countStringWithSqrt8(){
        mCalculator.stringInput = "√4+5";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("7")));
    }

    @Test
    public void countStringWithSqrt9(){
        mCalculator.stringInput = "√(4-5)";
        mCalculator.startCounting();
        String result = mCalculator.mainResult;
        assertThat(result, is(equalTo("NaN")));
    }

    @Test
    public void countStringWithSqrt10(){
        String result = mCalculator.countStringWithSqrt("√(4-5)");
        assertThat(result, is(equalTo("NaN")));
    }

    @Test
    public void countStringWithSqrt11(){
        String result = mCalculator.countStringWithSqrt("√(-5)");
        assertThat(result, is(equalTo("NaN")));
    }


}