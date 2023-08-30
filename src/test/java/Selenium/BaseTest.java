package Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static Selenium.config.WebDriverInit.closeDriver;
import static Selenium.config.WebDriverInit.getDriver;

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