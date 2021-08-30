package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.directory.NoSuchAttributeException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class HerokuTest {
    ChromeDriver driver;

    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void AddDelete() {
        driver.findElement(By.cssSelector("[href=\"/add_remove_elements/\"]")).click();
        driver.findElement(By.cssSelector("[onclick=\"addElement()\"]")).click();
        driver.findElement(By.className("added-manually")).click();
        try{
            driver.findElement(By.className("added-manually")).click();
            fail();
        }
        catch (NoSuchElementException exception){

        }
    }

    @Test
    public void Login() {
        driver.findElement(By.cssSelector("[href=\"/basic_auth\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void checkImageLoadCorrectly(){
        driver.findElement(By.cssSelector("[href=\"/broken_images\"]")).click();
        for(WebElement image:driver.findElements(By.cssSelector("img")))
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("is broken");
            }
    }

    @Test
    public void checkboxesTickCorrectly(){
        driver.findElement(By.cssSelector("[href=\"/checkboxes\"]")).click();
        for(WebElement checkbox:driver.findElements(By.cssSelector("[type=\"checkbox\"]"))){
            String originalAttribute=checkbox.getAttribute("checked");
            checkbox.click();
            checkbox.click();
            if(!Objects.equals(checkbox.getAttribute("checked"), originalAttribute)){
                fail();
            }
        }

    }

    @Test
    public void contextMenuAppears(){
        driver.findElement(By.cssSelector("[href=\"/context_menu\"]")).click();
        WebElement hotspot = driver.findElement(By.cssSelector("#hot-spot"));
        Actions action = new Actions(driver).contextClick(hotspot);
        action.build().perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void assertCorrectNumberOfElementsAppear(){
        driver.findElement(By.cssSelector("[href=\"/disappearing_elements\"]")).click();
        assertEquals(5, (driver.findElements(By.cssSelector("#content > div > ul > li"))).size());
    }

    @Test
    public void assertDragAndDropWorks(){
        driver.findElement(By.cssSelector("[href=\"/drag_and_drop\"]")).click();
        WebElement From = driver.findElement(By.id("column-a"));
        WebElement To = driver.findElement(By.id("column-b"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(From)
                .moveToElement(To)
                .release(To)
                .build();
        dragAndDrop.perform();
    }

    @Test
    public void assertOptionsSelectCorrectly(){
        driver.findElement(By.cssSelector("[href=\"/dropdown\"]")).click();
        driver.findElement(By.id("dropdown")).click();
        WebElement option1 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)"));
        WebElement option2 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        option1.click();
        assertEquals("true", option1.getAttribute("selected"));
        driver.findElement(By.id("dropdown")).click();
        option2.click();
        assertEquals("true", option2.getAttribute("selected"));
    }

    @Test
    public void assertCorrectNumberOfProfilesAndText(){
        driver.findElement(By.cssSelector("[href=\"/dynamic_content\"]")).click();
        assertEquals(3, driver.findElements(By.cssSelector("[src$=jpg]")).size());
        assertEquals(3, driver.findElements(By.cssSelector("[class=\"large-10 columns\"]")).size());
    }

    @Test
    public void assertDownloadTest(){
        driver.get("https://the-internet.herokuapp.com/download");
    }
}
