import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirefoxTests {
    WebDriver driver;
    String URL = "https://www.saucedemo.com/";
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    @Parameters({"username","password","selektor1","errorMessage","selektor2"})
    @Description("Login to saucedemo")
    @Epic("EP001")
    @Feature("FE001")
    @Story("Story: Login")
    @Step("Login to saucedemo")
    @Severity(SeverityLevel.MINOR)
    public void sauceDemoLogin(String username, String password, String selektor1, String errorMessage, String selektor2){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(selektor1)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector(selektor2)).getText(),errorMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
