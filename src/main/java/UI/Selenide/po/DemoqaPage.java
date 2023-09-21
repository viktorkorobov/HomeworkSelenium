package UI.Selenide.po;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.actions;


public class DemoqaPage {
    private final SelenideElement doubleClickButton = $x("//button[@id='doubleClickBtn']");
    private final SelenideElement rightClickButton = $x("//button[@id='rightClickBtn']");
    public SelenideElement getDoubleClickButton(){
        return $x("//p[@id='doubleClickMessage']");
    }
    public SelenideElement getContextClickButton(){
        return $x("//p[@id='rightClickMessage']");
    }
    public DemoqaPage clickDoubleClick(){
        doubleClickButton.shouldBe(visible, enabled).doubleClick();
        return page(DemoqaPage.class);
    }
    public DemoqaPage clickContextClick(){
        rightClickButton.shouldBe(visible, enabled).contextClick();
        return page(DemoqaPage.class);
    }

    /*droppable*/
    private final SelenideElement dragArea = $x("//div[@id='draggable']");
    private final SelenideElement dropArea = $x("//div[@id='droppable']");

    public SelenideElement dropped(){
        return $x("//div[@id='droppable']/p");
    }
    public DemoqaPage dragAndDropElement(){
        actions().dragAndDrop(dragArea.shouldBe(visible), dropArea.shouldBe(visible)).build().perform();
        return page(DemoqaPage.class);
    }

    /*Frame*/
    private final SelenideElement SelenideElementTextFromFrame = $x("/html/body/p");

    public String getTextFromFrame(){
        return SelenideElementTextFromFrame.shouldBe(visible).getText();
    }
    /**/
    private final SelenideElement upload =$x("//input[@id='uploadFile']");
//    public DemoqaPage uploadFile(String path){
//
//       // return ;
//    }
}
