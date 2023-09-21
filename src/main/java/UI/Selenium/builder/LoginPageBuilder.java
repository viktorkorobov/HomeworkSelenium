package UI.Selenium.builder;

import UI.Selenium.po.LoginPage;

public class LoginPageBuilder {
    private String username;
    private String password;
    public LoginPageBuilder withUsername(String username){
        this.username=username;
        return this;
    }
    public LoginPageBuilder withPassword(String password){
        this.password=password;
        return this;
    }
    public LoginPage build(){
        return new LoginPage()
                .enterUsername(username)
                .enterPassword(password);
    }
}