package Selenium.po;

import Selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By search = By.xpath("//input[@name='search']");
    private final  By result = By.xpath("//h1[@id='firstHeading']");
    private final  By element1 = By.xpath("//div[@class='mw-search-results-container']//span");

    public SearchPage clickOnSearch(){
        click(search);
        return this;
    }
    public SearchPage fillText(String text){
        send(search, text);
        return this;
    }

    public SearchPage enterSearch() {
        cliclEnter(search);
        return this;
    }
    public String getTitle(){
        return getTextFromElement(result);
    }
    public SearchPage clickOnElement(){
        click(element1);
        return this;
    }
}