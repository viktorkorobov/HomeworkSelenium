package Selenide;

import Selenide.po.SearchPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {

    @Test
    void shouldBeVisibleArticle(){
        open("https://ru.wikipedia.org/");

        new SearchPage()
                .fillSearch("Ubisoft")
                .clickEnter()
                .clickFirstArticle();

        assertThat(new SearchPage().getHeaderArticle().shouldBe(visible).getText()).as("").isEqualTo("Ubisoft");

    }
}
