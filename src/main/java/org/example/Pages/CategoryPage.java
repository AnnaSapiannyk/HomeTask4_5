package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class,\"catalog__inner\")]")
    private List<WebElement> productItems;

    @FindBy(xpath = "//button[contains(@class,\"product-grid__button\")]")
    private WebElement addToCartButton;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productItems));
        WebElement firstProduct = productItems.get(0);
        firstProduct.click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
}
