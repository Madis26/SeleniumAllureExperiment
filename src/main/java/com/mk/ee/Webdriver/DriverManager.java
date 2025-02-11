package com.mk.ee.Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverManager {

    protected ChromeDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public org.openqa.selenium.chrome.ChromeDriver getDriver() {
        if (null == driver) {
            //startService();
            createDriver();
        }
        return driver;
    }
}
