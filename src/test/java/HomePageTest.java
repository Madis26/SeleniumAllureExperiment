

import com.gargoylesoftware.htmlunit.Page;
import com.mk.ee.Page.HomePage;


import com.mk.ee.Util.PropertyLoader;
import com.mk.ee.Webdriver.DriverManager;
import com.mk.ee.Webdriver.DriverManagerFactory;
import com.mk.ee.Webdriver.DriverType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;


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
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public void afterMethod() {

        driverManager.quitDriver();
    }

    @Title("TestCase Title")
    @Features("Features")
    @Description("Here you can write testcase description")
    @TestCaseId("TEST-1")
    @Test
    public void CheckGmailUrlName() {
        homePage.gmailUrl();
        driver.manage().window().maximize();
        String assertGetGmailButtonExists = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/a[1]")).getText();
        Assert.assertEquals(assertGetGmailButtonExists, "KONTO LOOMINE");

    }

    @Title("TestCase Title2")
    @Features("Features2")
    @Description("Here you can write testcase description2")
    @TestCaseId("TEST-2")
    @Test
    public void CheckGmailUrlNameFail() {
        homePage.gmailUrl();
        driver.manage().window().maximize();
        String assertGetGmailButtonExists = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/a[1]")).getText();
        Assert.assertEquals(assertGetGmailButtonExists, "KONTO LOOMINES");

    }
}
