package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestTestOpenWeather {
    private String key;

    @BeforeEach
    public void __init__(){
       this.key= "e992ee2e2d038150a86ee416adf2faaf";
    }
    @Test
    public void tempTest(){
        given()
                .log().all()
                .param("lat", "-27.470125")
                .param("lon", "153.021072")
                .param("dt","1630116000")
                .param("appid",this.key)
                .param("units", "metric")
                .when()
                .get("https://api.openweathermap.org/data/2.5/onecall/timemachine")
                .then().assertThat().body("current.temp", equalTo(22.63F));
    }

    @Test
    public void sunriseTest(){
        given()
                .log().all()
                .param("lat", "-27.470125")
                .param("lon", "153.021072")
                .param("dt","1630116000")
                .param("appid",this.key)
                .param("units", "metric")
                .when()
                .get("https://api.openweathermap.org/data/2.5/onecall/timemachine")
                .then().assertThat().body("current.sunrise", equalTo(1630094775));
    }

    @Test
    public void sunsetTest(){
        given()
                .log().all()
                .param("lat", "-27.470125")
                .param("lon", "153.021072")
                .param("dt","1630116000")
                .param("appid",this.key)
                .param("units", "metric")
                .when()
                .get("https://api.openweathermap.org/data/2.5/onecall/timemachine")
                .then().assertThat().body("current.sunset", equalTo(1630135962));
    }
}
