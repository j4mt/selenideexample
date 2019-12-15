package com.j4mt.selenidefw.tests.expedia.flights;

import com.j4mt.selenidefw.pageobjects.expedia.flights.ExpediaFlightsPageObj;
import com.j4mt.selenidefw.tests.common.BaseTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class CheckCostOfFlightDisplayed extends BaseTest {

    private ExpediaFlightsPageObj expediaFlightsPageObj = new ExpediaFlightsPageObj();

    @Test
    public void checkCostLineResultsPage() throws ParseException {
        expediaFlightsPageObj.openExpediaHomePage();
        expediaFlightsPageObj.clickFlights();
        expediaFlightsPageObj.selectDepartCityAirport("LHR");
        expediaFlightsPageObj.selectReturnCityAirport("DUB");
        expediaFlightsPageObj.selectDepartureDate("today");
        expediaFlightsPageObj.selectReturnDate("today", 3);
        expediaFlightsPageObj.setNumOfPassengers(2, 0, 0);
        expediaFlightsPageObj.clickSearch();
    }

}
