package com.j4mt.selenidefw.tests.mercurytours.registration;

import com.j4mt.selenidefw.pageobjects.mercurytours.MercuryHomePageObj;
import com.j4mt.selenidefw.pageobjects.mercurytours.MercuryToursRegistrationPageObj;
import org.testng.annotations.Test;

public class RegistrationTest {

    @Test
    public void registerTest() {
        MercuryHomePageObj mercuryHomePage = new MercuryHomePageObj();
        MercuryToursRegistrationPageObj mercuryToursRegistration = new MercuryToursRegistrationPageObj();


        mercuryHomePage.openHomePage();
        mercuryHomePage.navigateTo("REGISTER");
        mercuryToursRegistration.fillContactInfo("John",
                "O'Rourke",
                "12345678",
                "adght@edeb.com");
        mercuryToursRegistration.fillMailingInfo("100 Hi Kerry",
                "Brazil Street",
                "Cork",
                "Munster",
                "KC1234",
                "IRELAND");
        mercuryToursRegistration.fillUserInfo("sqsorourkej",
                "123456",
                "123456");

    }
}
