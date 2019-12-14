package com.j4mt.selenidefw.pageobjects.expedia.flights;

import com.j4mt.selenidefw.pageobjects.utils.DateCalculator;
import org.openqa.selenium.By;

import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ExpediaFlightsPageObj extends ExpediaBasePageObj {

    private By flights = new By.ByXPath("//*[@id=\"tab-flight-tab-hp\" ]/span[contains(text(),'Flights')]");

    private By departCityAirport = new By.ByCssSelector("#flight-origin-hp-flight");

    private By returnCityAirport = new By.ByCssSelector("#flight-destination-hp-flight");

    private By departDate = new By.ByCssSelector("#flight-departing-hp-flight");

    private By returnDate = new By.ByCssSelector("#flight-returning-hp-flight");

    private By passengerSelector = new By.ByCssSelector("#traveler-selector-hp-flight > div > ul > li > button");

    private By adultsPlus = new By.ByCssSelector("#traveler-selector-hp-flight > div > ul > li > div > div > div > div.uitk-grid.step-input-outside.gcw-component.gcw-component-step-input.gcw-step-input.gcw-component-initialized > div:nth-child(4) > button > span.uitk-icon > svg");

    private By childrenPlus = new By.ByCssSelector("#traveler-selector-hp-flight > div > ul > li > div > div > div > div.children-wrapper > div.uitk-grid.step-input-outside.gcw-component.gcw-component-step-input.gcw-step-input.gcw-component-initialized > div:nth-child(4) > button > span.uitk-icon > svg > path:nth-child(1)");

    private By infantsPlus = new By.ByCssSelector("#traveler-selector-hp-flight > div > ul > li > div > div > div > div.infants-wrapper > div.uitk-grid.step-input-outside.gcw-component.gcw-component-step-input.gcw-step-input.gcw-component-initialized > div:nth-child(4) > button > span.uitk-icon > svg > path:nth-child(1)");

    /**
     * Selects fights button
     */
    public void clickFlights() {
        $(flights).click();
    }

    /**
     * @param cityAirport e.g DUB, etc
     */
    public void selectDepartCityAirport(String cityAirport) {
        $(departCityAirport).sendKeys(cityAirport);
        System.out.println("Debug point");
    }

    /**
     * @param cityAirport e.g DUB, etc
     */
    public void selectReturnCityAirport(String cityAirport) {
        $(returnCityAirport).sendKeys(cityAirport);
        System.out.println("Debug point");
    }

    /**
     * Sets number of passengers on ui
     *
     * @param adults
     * @param children
     * @param infants
     */
    public void setNumOfPassengers(int adults, int children, int infants) {
        $(passengerSelector).click();
        if (adults > 1) {
            for (int i = 0; i < (adults - 1); i++) {
                $(adultsPlus).click();
            }
        }
        for (int i = 0; i < children; i++) {
            $(childrenPlus).click();
        }
        for (int i = 0; i < infants; i++) {
            $(infantsPlus).click();
        }
    }

    /**
     * @param departDate format in mm/dd/yy
     */
    public void selectDepartureDate(String departDate) {
        if (departDate.equalsIgnoreCase("today")) {
            departDate = DateCalculator.getTodaysDateAmerican();
            System.out.println(departDate);
            $(this.departDate).sendKeys(departDate);
        } else {
            $(this.departDate).sendKeys(departDate);
        }
    }

    /**
     * @param returnDate    format in mm/dd/yy
     * @param daysTilReturn will calculate future date and enter if today str is used
     */
    public void selectReturnDate(String returnDate, int daysTilReturn) throws ParseException {
        if (returnDate.equalsIgnoreCase("today")) {
            returnDate = DateCalculator.calculateAmericanReturnDate(DateCalculator.getTodaysDateAmerican(), 3);
            $(this.returnDate).sendKeys(returnDate);
        } else if (!returnDate.equalsIgnoreCase("today")) {
            $(this.returnDate).sendKeys(returnDate);
        }
    }
}
