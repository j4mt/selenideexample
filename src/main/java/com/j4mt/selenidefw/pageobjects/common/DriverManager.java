package com.j4mt.selenidefw.pageobjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public class DriverManager {

    private static WebDriver webDriver;

    public static WebDriver getDriver(String drivername) {
        if (drivername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chrome\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments(Arrays.asList("start-maximized"));
            webDriver = new ChromeDriver(options);
        } else if (drivername.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.marionette", "src\\test\\resources\\drivers\\firefox\\geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            webDriver = new FirefoxDriver(capabilities);
        }
        return webDriver;
    }
}
