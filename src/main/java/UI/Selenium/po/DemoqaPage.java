package UI.Selenium.po;

import UI.Selenium.base.BaseMethod;
import UI.Selenium.base.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoqaPage extends BaseMethod {
    /*3*/
    private final By textFromFrame = By.xpath("/html/body/p");
    public String getTextFromFrame(){
        return getTextFromElement(textFromFrame);
    }
    /*2*/
    private final By upload =By.xpath("//input[@id='uploadFile']");
    public DemoqaPage uploadFile(String path){
        send(upload,path);
        return this;
    }
    /*1*/
    private final By table =By.xpath("//div[@class='rt-tbody']");
    public String getTextFromTable(int row, int column){
        WebElement tableTmp= getWait().until(driver -> driver.findElement(table));
        Table table1 = new Table(tableTmp);
        return table1.getValue(row, column);
    }
}
