package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton(){
        var loginButton= driver.findElements(By.id("loginButton"));
        for(var button: loginButton){
            if(button.isDisplayed()){
                button.click();
                break;
            }
        }
    }

    public WebElement getLoginButtonPopup(){
        return driver.findElement(By.cssSelector("[class=alert-message]"));
    }

    public void clickFormButton(){
        var FormButton = driver.findElements(By.cssSelector("[class=v-btn__content]")).get(2);
        FormButton.click();
    }

    public void clickPlanetButton(){
        var FormButton = driver.findElements(By.cssSelector("[class=v-btn__content]")).get(3);
        FormButton.click();
    }

    public void clickProfile(){
        var profile = driver.findElement(By.cssSelector("[class=\"v-icon notranslate material-icons theme--light\"]"));
        profile.click();
    }

    public WebElement getProfileErrorPopup(){
        return driver.findElement(By.className("v-messages__wrapper"));
    }

    public void sendKeysForename(String keys){
        driver.findElement(By.id("forename")).sendKeys(keys);
    }

    public void submitButtonClick(){
        driver.findElement(By.id("submit")).click();
    }

    public void clickProfileLogin(){
        var loginButton= driver.findElements(By.cssSelector("[id=loginButton]"));
        for(var button: loginButton){
            if(button.isDisplayed()){
                try {
                    button.click();
                    break;
                }
                catch (Exception InvalidSelectorException){
                    continue;
                }
            }
        }
    }
}
