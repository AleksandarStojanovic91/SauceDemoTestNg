package sort;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FirefoxTest {
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
    @Parameters({"username"})
    @Description("Sort products")
    @Epic("EP001")
    @Feature("FE002")
    @Story("Story: Sort")
    @Step("Sort products")
    @Severity(SeverityLevel.MINOR)
    public void sortByAZ(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        Select sort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sort.selectByValue("az");

        char slovo1 = driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo2 = driver.findElement(By.cssSelector(".inventory_item:nth-child(2)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo3 = driver.findElement(By.cssSelector(".inventory_item:nth-child(3)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo4 = driver.findElement(By.cssSelector(".inventory_item:nth-child(4)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo5 = driver.findElement(By.cssSelector(".inventory_item:nth-child(5)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo6 = driver.findElement(By.cssSelector(".inventory_item:nth-child(6)>div>a>.inventory_item_name")).getText().charAt(0);

        Assert.assertTrue(
                ((int) slovo1 <= (int) slovo2)&&
                        ((int) slovo2 <= (int) slovo3)&&
                        ((int) slovo3 <= (int) slovo4)&&
                        ((int) slovo4 <= (int) slovo5)&&
                        ((int) slovo5 <= (int) slovo6));

        String naziv1 = driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>div>a>.inventory_item_name")).getText();
        String naziv2 = driver.findElement(By.cssSelector(".inventory_item:nth-child(2)>div>a>.inventory_item_name")).getText();
        String naziv3 = driver.findElement(By.cssSelector(".inventory_item:nth-child(3)>div>a>.inventory_item_name")).getText();
        String naziv4 = driver.findElement(By.cssSelector(".inventory_item:nth-child(4)>div>a>.inventory_item_name")).getText();
        String naziv5 = driver.findElement(By.cssSelector(".inventory_item:nth-child(5)>div>a>.inventory_item_name")).getText();
        String naziv6 = driver.findElement(By.cssSelector(".inventory_item:nth-child(6)>div>a>.inventory_item_name")).getText();

        String array1[]= naziv1.split(" ");
        String array2[]= naziv2.split(" ");
        String array3[]= naziv3.split(" ");
        String array4[]= naziv4.split(" ");
        String array5[]= naziv5.split(" ");
        String array6[]= naziv6.split(" ");

        char slovoZadReci1 = array1[array1.length-1].charAt(0);
        char slovoZadReci2 = array2[array2.length-1].charAt(0);
        char slovoZadReci3 = array3[array3.length-1].charAt(0);
        char slovoZadReci4 = array4[array4.length-1].charAt(0);
        char slovoZadReci5 = array5[array5.length-1].charAt(0);
        char slovoZadReci6 = array6[array6.length-1].charAt(0);

        Assert.assertTrue(
                ((int) slovoZadReci1 <= (int) slovoZadReci2)&&
                        ((int) slovoZadReci2 <= (int) slovoZadReci3)&&
                        ((int) slovoZadReci3 <= (int) slovoZadReci4)&&
                        ((int) slovoZadReci4 <= (int) slovoZadReci5)&&
                        ((int) slovoZadReci5 <= (int) slovoZadReci6));
    }
    @Test
    @Parameters({"username"})
    @Description("Sort products")
    @Epic("EP001")
    @Feature("FE002")
    @Story("Story: Sort")
    @Step("Sort products")
    @Severity(SeverityLevel.MINOR)
    public void sortByZA(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        Select sort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sort.selectByValue("za");

        char slovo1 = driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo2 = driver.findElement(By.cssSelector(".inventory_item:nth-child(2)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo3 = driver.findElement(By.cssSelector(".inventory_item:nth-child(3)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo4 = driver.findElement(By.cssSelector(".inventory_item:nth-child(4)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo5 = driver.findElement(By.cssSelector(".inventory_item:nth-child(5)>div>a>.inventory_item_name")).getText().charAt(0);
        char slovo6 = driver.findElement(By.cssSelector(".inventory_item:nth-child(6)>div>a>.inventory_item_name")).getText().charAt(0);

        Assert.assertTrue(
                ((int) slovo1 >= (int) slovo2)&&
                        ((int) slovo2 >= (int) slovo3)&&
                        ((int) slovo3 >= (int) slovo4)&&
                        ((int) slovo4 >= (int) slovo5)&&
                        ((int) slovo5 >= (int) slovo6));

    }
    @Test
    @Parameters({"username"})
    @Description("Sort products")
    @Epic("EP001")
    @Feature("FE002")
    @Story("Story: Sort")
    @Step("Sort products")
    @Severity(SeverityLevel.MINOR)
    public void sortByASC(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        Select sort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sort.selectByValue("lohi");

        double cena1 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>.pricebar>div")).getText().substring(1, 5));
        double cena2 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(2)>.pricebar>div")).getText().substring(1, 5));
        double cena3 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(3)>.pricebar>div")).getText().substring(1, 5));
        double cena4 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(4)>.pricebar>div")).getText().substring(1, 5));
        double cena5 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(5)>.pricebar>div")).getText().substring(1, 5));
        double cena6 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(6)>.pricebar>div")).getText().substring(1, 5));

        Assert.assertTrue(
                ( cena1 <= cena2)&&
                        ( cena2 <= cena3)&&
                        ( cena3 <= cena4)&&
                        ( cena4 <= cena5)&&
                        ( cena5 <= cena6));

    }
    @Test
    @Parameters({"username"})
    @Description("Sort products")
    @Epic("EP001")
    @Feature("FE002")
    @Story("Story: Sort")
    @Step("Sort products")
    @Severity(SeverityLevel.MINOR)
    public void sortByDESC(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        Select sort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sort.selectByValue("hilo");

        double cena1 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(1)>.pricebar>div")).getText().substring(1,5));
        double cena2 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(2)>.pricebar>div")).getText().substring(1,5));
        double cena3 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(3)>.pricebar>div")).getText().substring(1,5));
        double cena4 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(4)>.pricebar>div")).getText().substring(1,5));
        double cena5 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(5)>.pricebar>div")).getText().substring(1,5));
        double cena6 = Double.parseDouble(driver.findElement(By.cssSelector(".inventory_item:nth-child(6)>.pricebar>div")).getText().substring(1,5));

        Assert.assertTrue(
                ( cena1 >= cena2)&&
                        ( cena2 >= cena3)&&
                        ( cena3 >= cena4)&&
                        ( cena4 >= cena5)&&
                        ( cena5 >= cena6));

    }
    @Test
    @Parameters({"username"})
    @Description("Add to Cart")
    @Epic("EP002")
    @Feature("FE001")
    @Story("Story: Add to Cart")
    @Step("Add to Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCart(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        int brojProizvoda = driver.findElements(By.cssSelector(".inventory_list>div")).size();
        for (int i = 1; i<=brojProizvoda;i++){
            driver.findElement(By.cssSelector(".inventory_item:nth-child("+i+")>div>button")).click();
        }
        driver.findElement(By.cssSelector(".shopping_cart_link.fa-layers.fa-fw")).click();
        int brojProizvodaUKorpi = driver.findElements(By.cssSelector(".cart_list>div")).size();
        Assert.assertEquals(brojProizvoda,brojProizvodaUKorpi-2);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
