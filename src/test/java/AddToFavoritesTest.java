import io.qameta.allure.testng.AllureTestNg;
import org.example.Pages.FavoritesPage;
import org.example.Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})

public class AddToFavoritesTest {
    private WebDriver driver;
    private ProductPage productPage;
    private FavoritesPage favoritesPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoolandia.com.ua/ua/shop/sobakam/suhoy-korm-dlya-sobak");
        productPage = new ProductPage(driver);
        favoritesPage = new FavoritesPage(driver);
    }

    @Test
    public void testAddToFavorites() {
        productPage.addFirstTwoProductsToFavorites();

        driver.get("https://zoolandia.com.ua/ua/wishlist.php");
        int numberOfFavoriteItems = favoritesPage.getNumberOfFavoriteItems();
        Assert.assertEquals(numberOfFavoriteItems, 1, "The number of favorite items is equal to 1.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
