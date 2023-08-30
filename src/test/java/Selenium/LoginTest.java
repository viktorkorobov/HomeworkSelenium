package Selenium;

import Selenium.builder.LoginPageBuilder;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Selenium.po.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"Smoke"}, dataProvider = "username")
    void loginToSiteUserName(String username){
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920,1080));
        new LoginPage().clickOnRegButton();

        LoginPage login = new LoginPageBuilder()
                .withUsername(username)
                .withPassword("Panasonic2023")
                .build();

        login.clickEnter();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new LoginPage().checkMessage())
                .as("Check Message")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
        softly.assertAll();
    }


    @DataProvider(name = "username")
    public Object[][] getUsername(){
        return new Object[][]{
                {"Vikkor1232"},
                {"Vikkor123@"}
        };
    }
}