

import com.mk.ee.Page.HomePage;


import com.mk.ee.Util.PropertyLoader;
import com.mk.ee.Webdriver.DriverManager;
import com.mk.ee.Webdriver.DriverManagerFactory;
import com.mk.ee.Webdriver.DriverType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePageTest {

    HomePage homePage;

    DriverManager driverManager;
    ChromeDriver driver;

    @BeforeClass
    public void testInit() {
        String applicationUrl = PropertyLoader.loadProperty("application.url");
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.navigate().to(applicationUrl);
    }

    @AfterClass
    public void afterMethod() {
        driverManager.quitDriver();
    }


    @Test
    public void successfulLogoutTest() {

        String assertLogOut = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).getText();
        Assert.assertEquals(assertLogOut, "Gmail");

    }
}
