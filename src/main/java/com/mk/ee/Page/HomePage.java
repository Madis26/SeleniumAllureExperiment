package com.mk.ee.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
    private ChromeDriver webDriver;
    @FindBy(className = "gb_P")
    @CacheLookup
    private WebElement gmailUrl;


    public HomePage() {
        PageFactory.initElements(this.webDriver, this);
    }


    //Methods
    public HomePage gmailUrl(){
        gmailUrl.click();
        return this;
    }
}
