import io.qameta.allure.testng.AllureTestNg;
import org.example.Pages.CartPage;
import org.example.Pages.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})

public class AddToCartTest {
    private WebDriver driver;
    private CategoryPage categoryPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoolandia.com.ua/ua/shop/sobakam/suhoy-korm-dlya-sobak");
        categoryPage = new CategoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddToCart() {
        categoryPage.selectFirstProduct();
        categoryPage.addToCart();

        driver.findElement(By.id("cart_popup"));
//        driver.get("https://zoolandia.com.ua/ua/shop/sobakam/suhoy-korm-dlya-sobak");
        int numberOfCartItems = cartPage.getNumberOfCartItems();
        Assert.assertEquals(numberOfCartItems, 1, "The product was added to the cart.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
