package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class, \"catalog__content-inner\")]")
    private List<WebElement> productItems;

    @FindBy(xpath = "//a[contains(@class, \"product-page__description-favorites\")]")
    private List<WebElement> addToFavoritesButtons;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void addFirstTwoProductsToFavorites() {
        for (int i = 0; i < 1; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesButtons.get(i)));
            addToFavoritesButtons.get(i).click();
        }
    }
}
