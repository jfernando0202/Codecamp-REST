package strategies;

import ui.Planet;
import ui.Planet2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MatchingPredicate {
    public static Predicate<Planet2> getPlanetGT4000(){
        return planet2 -> planet2.getRadius() > 4000;
    }

    public static BiPredicate<Planet, Planet> getGreaterDistance(){
        return (Planet isThisOne, Planet greaterThanThis) -> isThisOne.getDistance()>greaterThanThis.getDistance();
    }

    public static BiPredicate<Planet, Planet> getLesserDistance(){
        return (Planet isThisOne, Planet lessThanThis) -> isThisOne.getDistance()<lessThanThis.getDistance();
    }
}
