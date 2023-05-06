package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class loginPOM {
    WebDriver driver;

    //locator variables
    By username = By.name("user-name");
    By password = By.name("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    //constructor
    public loginPOM(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void getErrorMessage() {
        driver.findElement(errorMessage).getText();
    }
}
