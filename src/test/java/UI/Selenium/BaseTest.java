package UI.Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static UI.Selenium.config.WebDriverInit.closeDriver;
import static UI.Selenium.config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver=null;
    @BeforeSuite(groups = {"All","Smoke","Regression"})
    public void setUp(){
        driver =getDriver();
    }

    @AfterSuite(groups = {"All","Smoke","Regression"})
    public void tearDown(){
        closeDriver();
    }
}