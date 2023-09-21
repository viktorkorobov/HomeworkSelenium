package UI.Selenium.po;

import UI.Selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethod {
    private String username;
    private String password;
    private final By clickOnRegButton = By.xpath("//div//li[@id='pt-login']//span");
    private final  By loginUser = By.xpath("//div//input[@id='wpName1']");

    private final  By passwordUser = By.xpath("//div//input[@id='wpPassword1']");

    private final  By clickEnter = By.xpath("//div//button[@type='submit']");

    private final  By nameUser = By.xpath("//div //li[@id='pt-userpage']/a/span");

    private final  By message = By.xpath("//div[@class='cdx-message__content']");

    public LoginPage clickOnRegButton(){
        click(clickOnRegButton);
        return this;
    }

    public LoginPage enterUsername(String username){
        this.username=username;
        send(loginUser, username);
        return this;
    }
    public LoginPage enterPassword(String password){
        this.password=password;
        send(passwordUser, password);
        return this;
    }

    public LoginPage clickEnter(){
        click(clickEnter);
        return this;
    }

    public String checkUserName(){
        return getTextFromElement(nameUser);
    }

    public LoginPage checkMessage(){
        getTextFromElement(message);
        return this;
    }
}