package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//a[text()=\"Кабінет\"]")
    private WebElement enterButton;

    @FindBy(xpath = "//input[contains(@type, \"email\")]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@type, \"password\")]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@type, \"submit\")]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains (@class, \"has-error\")]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickEnterButton () {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("invalid@gmail.com");
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("invalidpassword");
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
