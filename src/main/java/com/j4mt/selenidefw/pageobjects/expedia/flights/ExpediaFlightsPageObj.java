package com.j4mt.selenidefw.pageobjects.expedia.flights;

import com.j4mt.selenidefw.pageobjects.utils.DateCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    private By searchBtn = new By.ByXPath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[7]/label/button");

    private By resultElement;

    private String resultXpath = "//div[@class=\"primary-content   custom-primary-padding\"]/span[contains(text(),'replaceMe')]";

    private By costResults = By.xpath("//div[@class=\"primary-content   custom-primary-padding\"]/span");

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
    }

    /**
     * @param cityAirport e.g DUB, etc
     */
    public void selectReturnCityAirport(String cityAirport) {
        $(returnCityAirport).sendKeys(cityAirport);
    }

    /**
     * Sets number of passengers on ui
     *
     * @param adults   number of adults to add
     * @param children number of children to add
     * @param infants  number of infants to add
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
            $(this.departDate).click();
            $(this.departDate).clear();
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
            returnDate = DateCalculator.calculateAmericanReturnDate(DateCalculator.getTodaysDateAmerican(), daysTilReturn);
            $(this.returnDate).click();
            $(this.returnDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $(this.returnDate).sendKeys(Keys.BACK_SPACE);
            $(this.returnDate).sendKeys(returnDate);
        } else if (!returnDate.equalsIgnoreCase("today")) {
            $(this.returnDate).sendKeys(returnDate);
        }
    }

    /**
     * clicks flights search button
     */
    public void clickSearch() {
        $(searchBtn).click();
    }

    /**
     * get cost string text from first result using a flight cost text in xpath search
     *
     * @param flightCost flight cost param for text to be selected from ui
     * @return test of flight cost if present on screen
     */
    public String getCostString(String flightCost) {
        String cost;
        resultXpath = resultXpath.replace("replaceMe", flightCost);
        resultElement = new By.ByXPath(resultXpath);
        cost = $(resultElement).getText();
        return cost;
    }

    public ArrayList<String> getTopCostsResults(int resultCnt) throws IOException {
        ArrayList<String> results;
        results = (ArrayList<String>) $$(costResults).texts();
        ArrayList<String> topResults = new ArrayList<>();

        if (resultCnt > results.size()) {
            throw new IOException("Unable to print results to console, Cost Results to return is greater than results on UI");
        }
        for (int i = 0; i < resultCnt; i++) {
            topResults.add(results.get(i));
        }
        return topResults;
    }

    public void printResultstoConsole(ArrayList<String> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(" | -- \t Cost  Result : " + (i + 1) + " ---------- |");
            System.out.println(" | ---\t\t " + results.get(i) + " ------------ |");
            System.out.println(" | ---------------------------------------------- |");
        }
    }
}
