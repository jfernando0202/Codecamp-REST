package ui;

import org.openqa.selenium.WebElement;

public class Planet {
    double radius;
    long distance;
    String name;
    public Planet(String name, long distance, double radius){
        this.name=name;
        this.distance=distance;
        this.radius=radius;
    }
    public String getName(){
        return name;
    }

    public double getRadius(){
        return radius;
    }
    public long getDistance(){
        return distance;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public void setDistance(long distance){
        this.distance=distance;
    }
    public void setName(String name){
        this.name=name;
    }
}
