package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {
    private final WebDriver driver;
    List<Planet> planets;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
        this.planets = new ArrayList<>();
    }

    public String getName(WebElement planet){
        return planet.findElement(By.className("image")).getAttribute("alt");
    }

    public WebElement getPlanet(String planet){
        for(var plan:getPlanets()){
            try {
                plan.findElement(By.cssSelector("img[alt=" + planet + "]"));
                return plan;
            }
            catch (Exception NoSuchElementException){

            }
        }
        return null;
    }

    public double getRadiusOfPlanet(String planet){
        return Double.parseDouble(getPlanet(planet).findElement(By.className("radius")).getText().replaceAll("km|,| ",""));
    }

    public Long getDistanceFromSunOfPlanet(String planet){
        return Long.parseLong(getPlanet(planet).findElement(By.className("distance")).getText().replaceAll("km|,| ",""));
    }

    public List<WebElement> getPlanets(){
        return driver.findElements(By.className("planet"));
    }

    public void createPlanets(){
        this.planets=new ArrayList<>();
        for (var planet:getPlanets()){
            planets.add(new Planet(getName(planet), getDistanceFromSunOfPlanet(getName(planet)), getRadiusOfPlanet(getName(planet))));
        }
    }

    public List<Planet> getPlanetObjects() {
        return this.planets;
    }
}
