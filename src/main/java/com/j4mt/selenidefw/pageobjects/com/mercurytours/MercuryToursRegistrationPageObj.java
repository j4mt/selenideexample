package com.j4mt.selenidefw.pageobjects.com.mercurytours;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MercuryToursRegistrationPageObj extends MercuryBasePageObj {

    // Contact information
    private By firstName = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input");
    private By lastName  = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input");
    private By phone     = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input");
    private By email     = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/input");

    // Mailing information
    private By address1  = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input");
    private By address2  = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input");
    private By city      = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input");
    private By stateProv = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input");
    private By postCode  = new By.ByXPath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input");
    private By country   = new By.ByName("country");

    // User information
    private By userName = new By.ByName("email");
    private By password = new By.ByName("password");
    private By confirmPassword = new By.ByName("confirmPassword");

    // Submit Button
    private By submitButton = new By.ByName("register");

    // use allure or serenity here for BDD IMPL for reports
    // @Step("Fill Contact Info")
    public MercuryToursRegistrationPageObj fillContactInfo( String firstName,
                                                            String lastName,
                                                            String phoneNumber,
                                                            String email){
        $(this.firstName).clear();
        $(this.firstName).setValue(firstName);
        $(this.lastName).clear();
        $(this.lastName).setValue(lastName);
        $(this.phone).clear();
        $(this.phone).setValue(phoneNumber);
        $(this.email).clear();
        $(this.email).setValue(email);

        return this;
    }
    // use allure or serenity here for BDD IMPL for reports
    // @Step("Fill Mailing info $")
    public MercuryToursRegistrationPageObj fillMailingInfo(String address1,
                                                           String address2,
                                                           String city,
                                                           String state,
                                                           String postCode,
                                                           String country){
        $(this.address1).clear();
        $(this.address1).setValue(address1);
        $(this.address2).clear();
        $(this.address2).setValue(address2);
        $(this.city).clear();
        $(this.city).setValue(city);
        $(this.stateProv).clear();
        $(this.stateProv).setValue(state);
        $(this.postCode).clear();
        $(this.postCode).setValue(postCode);
        $(this.country).click();
        $(this.country).selectOptionContainingText(country);
        return this;
    }

    // use allure or serenity here for BDD IMPL for reports
    // @Step("Fill user info and submit")
    public MercuryToursRegistrationPageObj fillUserInfo(
                                                           String username,
                                                           String password,
                                                           String confirmPassword){
        $(this.userName).clear();
        $(this.userName).setValue(username);
        $(this.password).clear();
        $(this.password).setValue(password);
        $(this.confirmPassword).clear();
        $(this.confirmPassword).setValue(confirmPassword);
        $(this.submitButton).click();
        return this;
    }
}
