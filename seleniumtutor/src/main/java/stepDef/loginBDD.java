package stepDef;

import POM.loginPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginBDD {
    WebDriver driver;
    Duration duration;
    WebDriverWait wait;
    String baseUrl = "https://www.saucedemo.com/";
    String drivePath = "src/test/java/resources/chromedriver.exe";
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", drivePath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div[1]"))
        );
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
//        driver.findElement(By.name("user-name")).sendKeys("standard_user");
//        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        loginPOM login = new loginPOM(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
//        driver.findElement(By.id("login-button")).click();
        loginPOM login = new loginPOM(driver);
        login.clickLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]"))
        );
        driver.quit();
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
//        driver.findElement(By.name("user-name")).sendKeys("standard_user07");
//        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        loginPOM login = new loginPOM(driver);
        login.enterUsername("standard_user07");
        login.enterPassword("secret_sauce");
    }

    @Then("I get an error message")
    public void iGetAnErrorMessage() {
//        wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"))
//        );
        loginPOM login = new loginPOM(driver);
        login.getErrorMessage();
        driver.quit();
    }

    @When("^I enter valid (.*) and (.*)$")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("^I get verify login (.*)$")
    public void iGetVerifyLoginResult(String result) {
        if (result.equals("pass")) {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]"))
            );
        } else {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"))
            );
        }
        driver.quit();
    }
}
