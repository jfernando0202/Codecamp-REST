package strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Planet;
import ui.PlanetPage;

public class MatchingStrategy implements Matchable{
    PlanetPage planetPage;
    public MatchingStrategy(PlanetPage planetPage){
        this.planetPage=planetPage;
        planetPage.createPlanets();
    }
    public boolean IsMostDistantFromSun(String planet){
        for(var plan:planetPage.getPlanetObjects()){
            if(plan.getDistance() > planetPage.getDistanceFromSunOfPlanet(planet)){
                return false;
            }
        }
        return true;
    }
}
