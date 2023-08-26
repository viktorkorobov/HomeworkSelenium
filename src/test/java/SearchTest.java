
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import po.SearchPage;

public class SearchTest extends BaseTest {

    @Test(groups = {"Regression"})
    void shouldBeVisibleResultText(String result){
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920,1080));
        new SearchPage()
                .clickOnSearch()
                .fillText("Ubisoft")
                .enterSearch()
                .clickOnElement();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new SearchPage().getTitle()).as("").isEqualTo("Ubisoft");
        softly.assertAll();
    }
}