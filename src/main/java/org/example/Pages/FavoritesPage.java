package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FavoritesPage {
    private WebDriver driver;
    private final WebDriverWait wait;



    @FindBy(xpath = "//div[contains(@class, \"personal-account personal-account--history\")]")
    private List<WebElement> favoriteItems;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfFavoriteItems() {
        wait.until(ExpectedConditions.visibilityOfAllElements(favoriteItems));
        return favoriteItems.size();
    }
}
