package com.j4mt.selenidefw.pageobjects.expedia.flights;

import static com.codeborne.selenide.Selenide.open;

public class ExpediaBasePageObj {

    private static final String URL = "https://www.expedia.com/";

    public void openExpediaHomePage(){
        open(URL);
    }
}
