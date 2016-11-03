package api.web.controller;


import api.web.domain.service.CalculationService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

public class CalculatorControllerTests {
    @Autowired
    CalculationService calculationService;
    LinkedHashMap<String, String> testCase = new LinkedHashMap<String, String>();

    CalculatorControllerTests() {
        testCase.put("(1+1)", "2.000000");
        testCase.put("( 1 + 1 )", "2.000000");
        testCase.put("(10+10)/(10-10)", "ERROR");
        testCase.put("10+10/10-10", "1.000000");
        testCase.put("-1-1", "-2.000000");
        testCase.put("-(1+1)", "-2.000000");
        testCase.put("(1)", "1.000000");
        testCase.put("1/0", "ERROR");
        testCase.put("1/3", "0.333333");
        testCase.put("()+()", "ERROR");
        testCase.put("(1+1))", "ERROR");
        testCase.put("a+1", "ERROR");
        testCase.put("(-2)*((1-1)*2)", "0.000000");
        testCase.put("0/2", "0.000000");
        testCase.put("e^2", "7.389056");
        testCase.put("pi", "3.141593");
        testCase.put("pi3", "ERROR");
        testCase.put("3*-2", "-6.000000");
        testCase.put("6/3+4^2/2*3", "26.000000");
        testCase.put("2^3^2", "512.000000");
        testCase.put("--1.5", "1.500000");
        testCase.put("2^-1", "0.500000");
        testCase.put(".34", "0.340000");
        testCase.put("00.34", "0.340000");
        testCase.put("1.", "1.000000");
        testCase.put("3 - - 2", "5.000000");
        testCase.put("2.3.1", "ERROR");
        testCase.put("1++2", "ERROR");
        testCase.put("*3", "ERROR");
        testCase.put("(((3)))", "3.000000");
        testCase.put("((2+3)*(4-5))/-1", "5.000000");
        testCase.put("27^(2/3)", "9.000000");
        testCase.put("27^2/3", "243.000000");
    }

    private void mainTest(String key) throws Exception {
        String resultValue = calculationService.calculate(key);
        Assert.assertEquals(testCase.get(key), resultValue);
    }

    @Test
    public void test_1() throws Exception { String key = "(1+1)"; mainTest(key); }

    @Test
    public void test_2() throws Exception { String key = "( 1 + 1 )"; mainTest(key); }

    @Test
    public void test_3() throws Exception { String key = "(10+10)/(10-10)"; mainTest(key); }

    @Test
    public void test_4() throws Exception { String key = "10+10/10-10"; mainTest(key); }

    @Test
    public void test_5() throws Exception { String key = "-1-1"; mainTest(key); }

    @Test
    public void test_6() throws Exception { String key = "-(1+1)"; mainTest(key); }

    @Test
    public void test_7() throws Exception { String key = "(1)"; mainTest(key); }

    @Test
    public void test_8() throws Exception { String key = "1/0"; mainTest(key); }

    @Test
    public void test_9() throws Exception { String key = "1/3"; mainTest(key); }

    @Test
    public void test_10() throws Exception { String key = "()+()"; mainTest(key); }

    @Test
    public void test_11() throws Exception { String key = "(1+1))"; mainTest(key); }

    @Test
    public void test_12() throws Exception { String key = "a+1"; mainTest(key); }

    @Test
    public void test_13() throws Exception { String key = "(-2)*((1-1)*2)"; mainTest(key); }

    @Test
    public void test_14() throws Exception { String key = "0/2"; mainTest(key); }

    @Test
    public void test_15() throws Exception { String key = "e^2"; mainTest(key); }

    @Test
    public void test_16() throws Exception { String key = "pi"; mainTest(key); }

    @Test
    public void test_17() throws Exception { String key = "pi3"; mainTest(key); }

    @Test
    public void test_18() throws Exception { String key = "3*-2"; mainTest(key); }

    @Test
    public void test_19() throws Exception { String key = "6/3+4^2/2*3"; mainTest(key); }

    @Test
    public void test_20() throws Exception { String key = "2^3^2"; mainTest(key); }

    @Test
    public void test_21() throws Exception { String key = "--1.5"; mainTest(key); }

    @Test
    public void test_22() throws Exception { String key = "2^-1"; mainTest(key); }

    @Test
    public void test_23() throws Exception { String key = ".34"; mainTest(key); }

    @Test
    public void test_24() throws Exception { String key = "00.34"; mainTest(key); }

    @Test
    public void test_25() throws Exception { String key = "1."; mainTest(key); }

    @Test
    public void test_26() throws Exception { String key = "3 - - 2"; mainTest(key); }

    @Test
    public void test_27() throws Exception { String key = "2.3.1"; mainTest(key); }

    @Test
    public void test_28() throws Exception { String key = "1++2"; mainTest(key); }

    @Test
    public void test_29() throws Exception { String key = "*3"; mainTest(key); }

    @Test
    public void test_30() throws Exception { String key = "(((3)))"; mainTest(key); }

    @Test
    public void test_31() throws Exception { String key = "((2+3)*(4-5))/-1"; mainTest(key); }

    @Test
    public void test_32() throws Exception { String key = "27^(2/3)"; mainTest(key); }

    @Test
    public void test_33() throws Exception { String key = "27^2/3"; mainTest(key); }
}