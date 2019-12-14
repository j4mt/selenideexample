package com.j4mt.selenidefw.tests.unittests;

import com.j4mt.selenidefw.pageobjects.utils.DateCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class DateCalculatorTest {

    @Test
    public void calculatorTest() throws ParseException {

        Assert.assertEquals(DateCalculator.calculateAmericanReturnDate("12/14/2019", 3), "12/17/2019");
    }
}
