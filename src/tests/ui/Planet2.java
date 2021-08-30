package ui;

import org.openqa.selenium.WebElement;

public class Planet2 {
    String name;
    double radius;
    WebElement exploreButton;
    public Planet2(String name, double radius, WebElement exploreButton){
        this.name=name;
        this.radius=radius;
        this.exploreButton=exploreButton;
    }
    public WebElement getExploreButton(){
        return exploreButton;
    }

    public double getRadius(){
        return radius;
    }

    public String getName(){
        return name;
    }
}
