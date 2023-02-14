package com.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
    WebDriver driver;
    Duration duration;
    WebDriverWait wait;
    String baseUrl = "https://www.saucedemo.com/";
    String drivePath = "src/test/java/resources/chromedriver.exe";

    @Test
    public void homePage() {
        System.setProperty("webdriver.chrome.driver", drivePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div[1]"))
        );
        driver.quit();;
    }

    @Test
    public void loginTest(){
        System.setProperty("webdriver.chrome.driver", drivePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]"))
        );
        driver.quit();
    }

    @Test
    public void logoutTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", drivePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("logout_sidebar_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div[1]"))
        );
        driver.quit();
    }
}
