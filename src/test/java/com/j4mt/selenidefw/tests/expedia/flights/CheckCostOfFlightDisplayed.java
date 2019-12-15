package com.j4mt.selenidefw.tests.expedia.flights;

import com.j4mt.selenidefw.pageobjects.expedia.flights.ExpediaFlightsPageObj;
import com.j4mt.selenidefw.tests.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CheckCostOfFlightDisplayed extends BaseTest {

    private ExpediaFlightsPageObj expediaFlightsPageObj = new ExpediaFlightsPageObj();

    @Test
    @Parameters("flightCost")
    public void checkCostLineResultsPage(String flightCost) throws ParseException, IOException {
        expediaFlightsPageObj.openExpediaHomePage();
        expediaFlightsPageObj.clickFlights();
        expediaFlightsPageObj.selectDepartCityAirport("LHR");
        expediaFlightsPageObj.selectReturnCityAirport("DUB");
        expediaFlightsPageObj.selectDepartureDate("today");
        expediaFlightsPageObj.selectReturnDate("today", 3);
        expediaFlightsPageObj.setNumOfPassengers(2, 0, 0);
        expediaFlightsPageObj.clickSearch();
        Assert.assertEquals(flightCost, expediaFlightsPageObj.getCostString(flightCost));
        expediaFlightsPageObj.printResultstoConsole(expediaFlightsPageObj.getTopCostsResults(3));
    }

    @Test
    @Parameters("flightCost")
    public void checkCostLineResultsPageNotEquals(String flightCost) throws ParseException {
        expediaFlightsPageObj.openExpediaHomePage();
        expediaFlightsPageObj.clickFlights();
        expediaFlightsPageObj.selectDepartCityAirport("LHR");
        expediaFlightsPageObj.selectReturnCityAirport("DUB");
        expediaFlightsPageObj.selectDepartureDate("today");
        expediaFlightsPageObj.selectReturnDate("today", 3);
        expediaFlightsPageObj.setNumOfPassengers(2, 0, 0);
        expediaFlightsPageObj.clickSearch();
        Assert.assertNotEquals("€0.92", expediaFlightsPageObj.getCostString(flightCost));
    }

}
