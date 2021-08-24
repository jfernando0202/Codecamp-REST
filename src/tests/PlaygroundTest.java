import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaygroundTest {
    @Test
    public void ExampleTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/");
        driver.findElement(By.cssSelector("#forename")).sendKeys("Joseph");
        driver.findElement(By.cssSelector("#submit.btn")).click();
        driver.findElement(By.cssSelector("#cancelButton > span")).click();
    }
}
