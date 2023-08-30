package Selenide.po;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private String username;
    private String password;
    private final SelenideElement clickOnRegButton = $x("//ul[@class='vector-menu-content-list']/li[@id='pt-login']//span");
    private final  SelenideElement loginUser = $x("//div//input[@id='wpName1']");

    private final  SelenideElement passwordUser = $x("//div//input[@id='wpPassword1']");

    private final  SelenideElement clickEnter = $x("//div//button[@type='submit']");

    private final  SelenideElement nameUser = $x("//div //li[@id='pt-userpage']/a/span");

    //private final  SelenideElement message = $x("//div[@class='cdx-message__content']");

    public LoginPage clickOnRegButton(){
        clickOnRegButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    public LoginPage enterUsername(String username){
        this.username=username;
        loginUser.shouldBe(visible).sendKeys(username);
        return page(LoginPage.class);
    }
    public LoginPage enterPassword(String password){
        this.password=password;
        passwordUser.shouldBe(visible).sendKeys(password);
        return page(LoginPage.class);
    }

    public LoginPage clickEnter(){
        clickEnter.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    public String checkUserName(){
        return nameUser.shouldBe(visible).getText();
    }
}
