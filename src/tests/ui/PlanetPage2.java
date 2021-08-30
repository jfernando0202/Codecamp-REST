package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlanetPage2 {
    ChromeDriver driver;
    public PlanetPage2(ChromeDriver driver){
        this.driver=driver;
    }
    public List<Planet2> getPlanets(){
        var planet2sWeb = driver.findElements(By.className("planet"));
        var planet2s = new ArrayList<Planet2>();
        for(var planet2 : planet2sWeb){
            planet2s.add(getPlanet(planet2));
        }
        return planet2s;
    }

    public Planet2 getPlanet(WebElement planet2) {
        String name = planet2.findElement(By.className("image")).getAttribute("alt");
        double radius = Double.parseDouble(planet2.findElement(By.className("radius")).getText().replaceAll(",| |km",""));
        WebElement exploreButton = planet2.findElement(By.cssSelector("[type=button]"));
        return new Planet2(name, radius, exploreButton);
    }

    public void clickExploreButton(WebElement exploreButton){
        exploreButton.click();
    }

    public String getPopupText(){
        return driver.findElement(By.cssSelector("[class=\"snackbar popup-message mr-auto\"]")).getText();
    }

    public void closePopup(){
        driver.findElement(By.cssSelector("[aria-label=\"close\"]")).click();
    }

    public void waitForPopup(){
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class=\"snackbar popup-message mr-auto\"]"))));
    }
}
