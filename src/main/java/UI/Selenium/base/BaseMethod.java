package UI.Selenium.base;

import UI.Selenium.config.WebDriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class BaseMethod {
    protected Actions getAction(){
        return new Actions(WebDriverInit.getDriver());
    }
    public WebDriverWait getWait(){
        return new WebDriverWait(WebDriverInit.getDriver(), ofSeconds(10));
    }

    protected void click(By locator){
        getWait().until(d -> d.findElement(locator)).click();

    }
    protected void dobleClick(By locator){
       WebElement doubleElement = getWait().until(d -> d.findElement(locator));
        getAction().doubleClick(doubleElement).build().perform();
    }
    protected void contextClick(By locator){
        WebElement contextClick = getWait().until(d -> d.findElement(locator));
        getAction().contextClick(contextClick).build().perform();
    }

    protected void dragAndDrop(By drag,By drop){
        WebElement dragElement = getWait().until(d -> d.findElement(drag));
        WebElement dropElement = getWait().until(d -> d.findElement(drop));
        getAction().dragAndDrop(dragElement, dropElement).build().perform();
    }

    protected void send(By locator, String text){
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected void cliclEnter(By locator){
        getWait().until(d ->  d.findElement(locator)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By locator){
        return getWait().until(d -> d.findElement(locator)).getText();
    }
}