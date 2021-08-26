package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private final WebDriver driver;
    public FormPage (WebDriver driver){
        this.driver = driver;
    }
    public void sendKeysNameField(String keys){
        var NameField = driver.findElement(By.cssSelector("[id=\"name\"]"));
        NameField.sendKeys(keys);
    }

    public void sendKeysEmailField(String keys){
        var EmailField = driver.findElement(By.cssSelector("[id=\"email\"]"));
        EmailField.sendKeys(keys);
    }

    public void clickAgreeBox(){
        var AgreeBox = driver.findElement(By.cssSelector("[class=v-input--selection-controls__ripple]"));
        AgreeBox.click();
    }

    public void clickSubmitButton(){
        var Submit = driver.findElement(By.cssSelector("[class=\"v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default\"]"));
        Submit.click();
    }

    public boolean errorMessageByIdInvisible(String id){
        return driver.findElements(By.cssSelector(id)).isEmpty();
    }
}
