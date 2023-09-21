package UI.Selenide;

import UI.Selenide.po.DemoqaPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoqaTest{
    @Test
    public void doubleAndContextClickCheck(){
        open("https://demoqa.com/buttons");
        new DemoqaPage()
                .clickDoubleClick()
                .clickContextClick();
        SoftAssertions softy =new SoftAssertions();
        softy.assertThat(new DemoqaPage().getDoubleClickButton().shouldBe(visible).getText())
                .as("Text wasn't found")
                .isEqualTo("You have done a double click");
        softy.assertThat(new DemoqaPage().getContextClickButton().shouldBe(visible).getText())
                .as("Text wasn't found")
                .isEqualTo("You have done a right click");
        softy.assertAll();
    }

    @Test
    public void dragAndDropTest(){
        open("https://demoqa.com/droppable");
        new DemoqaPage()
                .dragAndDropElement();

        assertThat(new DemoqaPage().dropped().shouldBe(visible).getText())
                .as("Text wasn't found").isEqualTo("Dropped!");

    }
    @Test
    public void getFrameText(){
        open("https://demoqa.com/nestedframes");
        switchTo().frame($x("//iframe[@id='frame1']"));
        switchTo().frame($x("//iframe[@srcdoc='<p>Child Iframe</p>']"));

        SoftAssertions softy = new SoftAssertions();

        softy.assertThat(new DemoqaPage().getTextFromFrame())
                .as("Not enter to frame")
                .isEqualTo("Child Iframe");
        softy.assertAll();
        switchTo().defaultContent();
    }

    @Test
    public void uploadFileTest() throws InterruptedException {
        open("https://demoqa.com/upload-download");
        $x("//input[@id='uploadFile']")
                .uploadFile(new File("C:\\Users\\Viktor\\IdeaProjects\\QA-Automation\\HomeworkSelenium\\text.txt"));
    }
}
