package com.j4mt.selenidefw.modal.expedia;

/**
 * Gather data from the first # rows of results returned by Expedia into a data object.
 * Print to the console the departure time, Airline, Price displayed in these # rows from your data object
 */
public class FlightResult {

    private String departureTime;

    private String Airline;

    private String Price;

    public FlightResult(String departureTime, String airline, String price) {
        this.departureTime = departureTime;
        Airline = airline;
        Price = price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
