package UI.Selenium;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import UI.Selenium.po.DemoqaPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoqaTest extends BaseTest{

    /*3*/
    @Test
    public void getFrameText(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().setSize(new Dimension(1920,1080));

        WebElement frame1=driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);
        WebElement frame2=driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frame2);

        SoftAssertions softy = new SoftAssertions();

        softy.assertThat(new DemoqaPage().getTextFromFrame())
                .as("Not enter to frame")
                .isEqualTo("Child Iframe");
        softy.assertAll();
        driver.switchTo().defaultContent();
    }
    /*2*/
    @Test
    public void uploadFileTest(){
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().setSize(new Dimension(1920,1080));

        new DemoqaPage()
                .uploadFile("C:\\Users\\Viktor\\IdeaProjects\\QA-Automation\\HomeworkSelenium\\text.txt");

    }
    /*1*/
    @Test
    public void getTextFromTable(){
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().setSize(new Dimension(1920,1080));

        assertThat(new DemoqaPage().getTextFromTable(3,5))
                .as("Is not correct")
                .isEqualTo("2000");
    }
}
