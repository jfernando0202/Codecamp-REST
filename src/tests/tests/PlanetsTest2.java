package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import strategies.MatchingPredicate;
import ui.Planet2;
import ui.PlanetPage2;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetsTest2 {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d21vtxezke9qd9.cloudfront.net/#/planets");
    }

    public void clickAllPlanetsOver4000kmRadiusAndVerfiyPopup(Predicate<Planet2> predicate){
        PlanetPage2 planetPage2 = new PlanetPage2(driver);
        for(var planet:planetPage2.getPlanets()){
            if(predicate.test(planet)){
                planet.getExploreButton().click();
                planetPage2.waitForPopup();
                if(planetPage2.getPopupText().contains(planet.getName())){
                    planetPage2.closePopup();
                }
                else{
                    fail(planet.getName()+" was not found in popup!");
                }
            }
        }
    }

    @Test
    public void predicateTryout(){
        clickAllPlanetsOver4000kmRadiusAndVerfiyPopup(MatchingPredicate.getPlanetGT4000());
    }
}
