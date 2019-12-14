package com.j4mt.selenidefw.tests.common;

import com.codeborne.selenide.WebDriverRunner;
import com.j4mt.selenidefw.pageobjects.common.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        WebDriverRunner.setWebDriver(DriverManager.getDriver(browser));
    }

    @AfterTest
    public void cleanupBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
