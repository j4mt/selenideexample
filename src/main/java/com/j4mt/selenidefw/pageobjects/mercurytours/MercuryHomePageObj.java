package com.j4mt.selenidefw.pageobjects.mercurytours;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MercuryHomePageObj extends MercuryBasePageObj{

    private static final String URL = "http://newtours.demoaut.com/mercurywelcome.php";
    private static final String mercuryLogo = "";
    /** Instantiates a new Presta home. */

    public MercuryHomePageObj() {
    }

    public void openHomePage(){
        open(URL);
    }

    //@Step("Navigate to menu item $")
    public void navigateTo(String linkText){
        $(By.linkText(linkText)).click();
    }
}
