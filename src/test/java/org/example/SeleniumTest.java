package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {


    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginLogout() {
        // Open website
        driver.get("https://the-internet.herokuapp.com/login");

        // Login using invalid credentials
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPass");
        driver.findElement(By.className("radius")).click();

        // Validate unsuccessful login
        WebElement error = driver.findElement(By.id("flash"));
        Assert.assertTrue(error.getText().contains("Your username is invalid!"));

        // Login using the recommended username and password
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        // Validate successful login
        WebElement success = driver.findElement(By.id("flash"));
        Assert.assertTrue(success.getText().contains("You logged into a secure area!"));

        // Logout
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

        // Validate successful logout
        WebElement logoutMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"));
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
