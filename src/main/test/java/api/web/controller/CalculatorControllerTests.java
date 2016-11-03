package api.web.controller;


import api.web.domain.service.CalculationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class CalculatorControllerTests {
    LinkedHashMap<String, String> testCase = new LinkedHashMap<String, String>();;
    CalculationService calculationService;

    private void mainTest(String key) throws Exception {
        String resultValue = this.calculationService.calculate(key);
        Assert.assertEquals(testCase.get(key), resultValue);
    }

    @Before
    public void init() { this.calculationService = new CalculationService(); }

    @Test
    public void test_1() throws Exception { testCase.put("(1+1)", "2.000000"); String key = "(1+1)"; mainTest(key); }

    @Test
    public void test_2() throws Exception { testCase.put("( 1 + 1 )", "2.000000"); String key = "( 1 + 1 )"; mainTest(key); }

    @Test
    public void test_3() throws Exception { testCase.put("(10+10)/(10-10)", "ERROR"); String key = "(10+10)/(10-10)"; mainTest(key); }

    @Test
    public void test_4() throws Exception { testCase.put("10+10/10-10", "1.000000"); String key = "10+10/10-10"; mainTest(key); }

    @Test
    public void test_5() throws Exception { testCase.put("-1-1", "-2.000000"); String key = "-1-1"; mainTest(key); }

    @Test
    public void test_6() throws Exception { testCase.put("-(1+1)", "-2.000000"); String key = "-(1+1)"; mainTest(key); }

    @Test
    public void test_7() throws Exception { testCase.put("(1)", "1.000000"); String key = "(1)"; mainTest(key); }

    @Test
    public void test_8() throws Exception { testCase.put("1/0", "ERROR"); String key = "1/0"; mainTest(key); }

    @Test
    public void test_9() throws Exception { testCase.put("1/3", "0.333333"); String key = "1/3"; mainTest(key); }

    @Test
    public void test_10() throws Exception { testCase.put("()+()", "ERROR"); String key = "()+()"; mainTest(key); }

    @Test
    public void test_11() throws Exception { testCase.put("(1+1))", "ERROR"); String key = "(1+1))"; mainTest(key); }

    @Test
    public void test_12() throws Exception { testCase.put("a+1", "ERROR"); String key = "a+1"; mainTest(key); }

    @Test
    public void test_13() throws Exception { testCase.put("(-2)*((1-1)*2)", "0.000000"); String key = "(-2)*((1-1)*2)"; mainTest(key); }

    @Test
    public void test_14() throws Exception { testCase.put("0/2", "0.000000"); String key = "0/2"; mainTest(key); }

    @Test
    public void test_15() throws Exception { testCase.put("e^2", "7.389056"); String key = "e^2"; mainTest(key); }

    @Test
    public void test_16() throws Exception { testCase.put("pi", "3.141593"); String key = "pi"; mainTest(key); }

    @Test
    public void test_17() throws Exception { testCase.put("pi3", "ERROR"); String key = "pi3"; mainTest(key); }

    @Test
    public void test_18() throws Exception { testCase.put("3*-2", "-6.000000"); String key = "3*-2"; mainTest(key); }

    @Test
    public void test_19() throws Exception { testCase.put("6/3+4^2/2*3", "26.000000"); String key = "6/3+4^2/2*3"; mainTest(key); }

    @Test
    public void test_20() throws Exception { testCase.put("2^3^2", "512.000000"); String key = "2^3^2"; mainTest(key); }

    @Test
    public void test_21() throws Exception { testCase.put("--1.5", "1.500000"); String key = "--1.5"; mainTest(key); }

    @Test
    public void test_22() throws Exception { testCase.put("2^-1", "0.500000"); String key = "2^-1"; mainTest(key); }

    @Test
    public void test_23() throws Exception { testCase.put(".34", "0.340000"); String key = ".34"; mainTest(key); }

    @Test
    public void test_24() throws Exception { testCase.put("00.34", "0.340000"); String key = "00.34"; mainTest(key); }

    @Test
    public void test_25() throws Exception { testCase.put("1.", "1.000000"); String key = "1."; mainTest(key); }

    @Test
    public void test_26() throws Exception { testCase.put("3 - - 2", "5.000000"); String key = "3 - - 2"; mainTest(key); }

    @Test
    public void test_27() throws Exception { testCase.put("2.3.1", "ERROR"); String key = "2.3.1"; mainTest(key); }

    @Test
    public void test_28() throws Exception { testCase.put("1++2", "ERROR"); String key = "1++2"; mainTest(key); }

    @Test
    public void test_29() throws Exception { testCase.put("*3", "ERROR"); String key = "*3"; mainTest(key); }

    @Test
    public void test_30() throws Exception { testCase.put("(((3)))", "3.000000"); String key = "(((3)))"; mainTest(key); }

    @Test
    public void test_31() throws Exception { testCase.put("((2+3)*(4-5))/-1", "5.000000"); String key = "((2+3)*(4-5))/-1"; mainTest(key); }

    @Test
    public void test_32() throws Exception { testCase.put("27^(2/3)", "9.000000"); String key = "27^(2/3)"; mainTest(key); }

    @Test
    public void test_33() throws Exception { testCase.put("27^2/3", "243.000000"); String key = "27^2/3"; mainTest(key); }
}