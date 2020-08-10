import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }


    @Test(priority = 1, description = "Verify Logo Presence on Google Page")
    @Description("Verify Logo Presence on Google Page")
    @Epic("EP001")
    @Feature("FE001: Display Logo")
    @Story("Story: logo Presence")
    @Step("Verify Logo Presence")
    @Severity(SeverityLevel.MINOR)
    public void isLogoDisplayedGoogle(){
        boolean isLogoDisplayed = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);
    }

    @Test(priority = 2)
    public void isSearchInputDisplayedGoogle(){
        boolean isSearchInputDisplayed = driver.findElement(By.cssSelector("[name=\"q\"]")).isDisplayed();
        Assert.assertTrue(isSearchInputDisplayed);
    }

    @Test(priority = 3)
    public void isSearchButtonDisplayedGoogle(){
        boolean isSearchButtonDisplayed = driver.findElement(By.cssSelector("div.FPdoLc.tfB0Bf>center>[name=\"btnK\"]")).isDisplayed();
        Assert.assertTrue(isSearchButtonDisplayed);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}