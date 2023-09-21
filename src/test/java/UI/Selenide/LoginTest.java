package UI.Selenide;

import UI.Selenide.po.LoginPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest {

    @Test
    public void loginToSystem(){
        open("https://ru.wikipedia.org/");
        new LoginPage()
                .clickOnRegButton()
                .enterUsername("Vikkor123")
                .enterPassword("Panasonic2023")
                .clickEnter();

        assertThat(new LoginPage().checkUserName()).as("Not found").isEqualTo("Vikkor123");
    }
}
