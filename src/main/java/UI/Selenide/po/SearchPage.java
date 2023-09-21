package UI.Selenide.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static java.time.Duration.ofSeconds;

public class SearchPage {
    private final SelenideElement searchField = $x("//input[@class='vector-search-box-input']");
    private final SelenideElement firstArticle = $x("//div[@class='mw-search-result-heading']/a[@title='Ubisoft']");

    public SelenideElement getHeaderArticle(){
        return $x("//span[@class='mw-page-title-main']");
    }
    public SearchPage fillSearch(String text){
        searchField.shouldBe(visible).sendKeys(text);
        return page(SearchPage.class);
    }
    public SearchPage clickEnter(){
        searchField.shouldBe(visible).sendKeys(Keys.ENTER);
        return page(SearchPage.class);
    }
    public SearchPage clickFirstArticle(){
        firstArticle.shouldBe(visible, ofSeconds(10)).click();
        return page(SearchPage.class);
    }
}
