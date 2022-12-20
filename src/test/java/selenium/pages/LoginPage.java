package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.utilities.BasePage;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }

    public void fillInUsername(String username) {
        sendKeys(usernameInput, username);
    }

    public void passwordInput(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public WebElement getPasswordInput() {
        return getElement(passwordInput);
    }

    public WebElement getUsernameInput() {
        return getElement(usernameInput);
    }

    public WebElement getLoginElement() {
        return getElement(loginButton);
    }

    public void login(String username, String password) {
        fillInUsername(username);
        passwordInput(password);
        clickLoginButton();
    }

}
