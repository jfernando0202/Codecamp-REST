package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import strategies.MatchingPredicate;
import ui.FormPage;
import ui.HomePage;
import ui.PlanetPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PlaygroundTest {
    private ChromeDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d21vtxezke9qd9.cloudfront.net");
        homePage = new HomePage(driver);
    }
    @Test
    public void ExampleTest(){
        homePage.sendKeysForename("Joseph");
        homePage.submitButtonClick();
    }

    @Test
    public void LoginButtonWorksTest(){
        homePage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(homePage.getLoginButtonPopup()));
        assertEquals("You clicked the login button", homePage.getLoginButtonPopup().getText());
    }

    @Test
    public void CheckInvalidLogin(){
        homePage.clickProfile();
        homePage.clickProfileLogin();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.getProfileErrorPopup()));
        assertEquals("Invalid user and password!", homePage.getProfileErrorPopup().getText());
    }
    @Test
    public void CheckFormsLoginWorksPositiveTesting(){
        /*var homePage = new ui.HomePage(driver);
        var FormButton = driver.findElements(By.cssSelector("[class=v-btn__content]")).get(2);
        FormButton.click();
        var NameField = getElement("[id=\"name\"]");
        NameField.sendKeys("Joseph");
        var EmailField = getElement("[id=\"email\"]");
        EmailField.sendKeys("Joseph@gmail.com");
        var AgreeBox = getElement("[class=v-input--selection-controls__ripple]");
        AgreeBox.click();
        var Submit = new ui.HomePage(driver).getElementCssSelector("[class=\"v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default\"]");
        Submit.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"v-icon notranslate ml-3 mr-1 v-icon--link material-icons theme--dark white--text\"]")));
        assertTrue(true);*/
    }

    @Test
    public void CheckErrorsInForms(){
        FormPage formPage = new FormPage(driver);
        homePage.clickFormButton();
        formPage.sendKeysNameField("Joseph");
        formPage.sendKeysEmailField("Joseph@gmail.com");
        formPage.clickAgreeBox();
        formPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(formPage.errorMessageByIdInvisible("#name-err"));
        assertTrue(formPage.errorMessageByIdInvisible("#email-err"));
        assertTrue(formPage.errorMessageByIdInvisible("#agree-err"));
    }

    @Test
    public void AssertPlanetRadius(){
        PlanetPage planetPage = new PlanetPage(driver);
        homePage.clickPlanetButton();
        assertEquals(2439, planetPage.getRadiusOfPlanet("Mercury"));
    }

    @Test
    public void AssertPlanetDistanceFromSun(){
        PlanetPage planetPage = new PlanetPage(driver);
        homePage.clickPlanetButton();
        assertEquals(2439, planetPage.getDistanceFromSunOfPlanet("Mercury"));
    }

    @Test
    public void AssertPlanetFurtherestFromSun(){
        PlanetPage planetPage = new PlanetPage(driver);
        homePage.clickPlanetButton();
        assertEquals("Neptune", planetPage.matchPlanet(MatchingPredicate.getGreaterDistance()).getName());
    }

    @Test
    public void AssertPlanetClosestToSun(){
        PlanetPage planetPage = new PlanetPage(driver);
        homePage.clickPlanetButton();
        assertEquals("Mercury", planetPage.matchPlanet(MatchingPredicate.getLesserDistance()).getName());
    }

}
