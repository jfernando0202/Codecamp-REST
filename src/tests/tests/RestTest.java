package tests;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestTest {
    private String key;

    @BeforeEach
    private void __init__(){
       this.key= "ba9d5cca-358b-462c-b74d-25afbd1d3e31";
    }
    @Test
    public void statusCodeTest(){
        given().header("auth-key", this.key)
                .when().get("https://digitalapi.auspost.com.au/postcode/search.json?q=Melbourne&state=VIC")
                .then().assertThat().statusCode(200);
    }
    @Test
    public void postcodeTest(){
        given()
                .header("auth-key", this.key)
                .param("q", "Tascott")
                .param("state", "NSW")
                .when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat().body("localities.locality.postcode", equalTo(2250));
    }
    @Test
    public void latitudeTest(){
        given()
                .header("auth-key", this.key)
                .param("q", "Melbourne")
                .param("state", "VIC")
                .when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat().body("localities.locality[0].latitude", equalTo(2250));
    }
}
