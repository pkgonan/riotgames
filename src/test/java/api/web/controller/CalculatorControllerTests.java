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
    public void test_1() throws Exception { String key = "(1+1)"; testCase.put(key, "2.000000");  mainTest(key); }

    @Test
    public void test_2() throws Exception { String key = "( 1 + 1 )"; testCase.put(key, "2.000000"); mainTest(key); }

    @Test
    public void test_3() throws Exception { String key = "(10+10)/(10-10)"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_4() throws Exception { String key = "10+10/10-10"; testCase.put(key, "1.000000"); mainTest(key); }

    @Test
    public void test_5() throws Exception { String key = "-1-1"; testCase.put(key, "-2.000000"); mainTest(key); }

    @Test
    public void test_6() throws Exception { String key = "-(1+1)"; testCase.put(key, "-2.000000"); mainTest(key); }

    @Test
    public void test_7() throws Exception { String key = "(1)"; testCase.put(key, "1.000000"); mainTest(key); }

    @Test
    public void test_8() throws Exception { String key = "1/0"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_9() throws Exception { String key = "1/3"; testCase.put(key, "0.333333"); mainTest(key); }

    @Test
    public void test_10() throws Exception { String key = "()+()"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_11() throws Exception { String key = "(1+1))"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_12() throws Exception { String key = "a+1"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_13() throws Exception { String key = "(-2)*((1-1)*2)"; testCase.put(key, "0.000000"); mainTest(key); }

    @Test
    public void test_14() throws Exception { String key = "0/2"; testCase.put(key, "0.000000"); mainTest(key); }

    @Test
    public void test_15() throws Exception { String key = "e^2"; testCase.put(key, "7.389056"); mainTest(key); }

    @Test
    public void test_16() throws Exception { String key = "pi"; testCase.put(key, "3.141593"); mainTest(key); }

    @Test
    public void test_17() throws Exception { String key = "pi3"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_18() throws Exception { String key = "3*-2"; testCase.put(key, "-6.000000"); mainTest(key); }

    @Test
    public void test_19() throws Exception { String key = "6/3+4^2/2*3"; testCase.put(key, "26.000000"); mainTest(key); }

    @Test
    public void test_20() throws Exception { String key = "2^3^2"; testCase.put(key, "512.000000"); mainTest(key); }

    @Test
    public void test_21() throws Exception { String key = "--1.5"; testCase.put(key, "1.500000"); mainTest(key); }

    @Test
    public void test_22() throws Exception { String key = "2^-1"; testCase.put(key, "0.500000"); mainTest(key); }

    @Test
    public void test_23() throws Exception { String key = ".34"; testCase.put(key, "0.340000"); mainTest(key); }

    @Test
    public void test_24() throws Exception { String key = "00.34"; testCase.put(key, "0.340000"); mainTest(key); }

    @Test
    public void test_25() throws Exception { String key = "1."; testCase.put(key, "1.000000"); mainTest(key); }

    @Test
    public void test_26() throws Exception { String key = "3 - - 2"; testCase.put(key, "5.000000"); mainTest(key); }

    @Test
    public void test_27() throws Exception { String key = "2.3.1"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_28() throws Exception { String key = "1++2"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_29() throws Exception { String key = "*3"; testCase.put(key, "ERROR"); mainTest(key); }

    @Test
    public void test_30() throws Exception { String key = "(((3)))"; testCase.put(key, "3.000000"); mainTest(key); }

    @Test
    public void test_31() throws Exception { String key = "((2+3)*(4-5))/-1"; testCase.put(key, "5.000000"); mainTest(key); }

    @Test
    public void test_32() throws Exception { String key = "27^(2/3)"; testCase.put(key, "9.000000"); mainTest(key); }

    @Test
    public void test_33() throws Exception { String key = "27^2/3"; testCase.put(key, "243.000000"); mainTest(key); }
}