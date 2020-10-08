import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasketPageTest {
    private WebDriver driver;
    private BasketPage basketPage;
    URL dermaEProductURL = new URL("https://www.iherb.com/pr/Derma-E-Sensitive-Skin-Moisturizing-Cream-2-oz-56-g/6371");

    public BasketPageTest() throws MalformedURLException {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Таисия\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        basketPage = new BasketPage(driver);
        driver.get(String.valueOf(dermaEProductURL));
        BasketPage addToCartButtonFirstProduct = basketPage.clickAddToCartButton();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        BasketPage pageBasket = basketPage.clickBasketButton();
    }

    @Test
    public void quantityItems() {
        String positions = basketPage.getItemsInTheBasketText();
        Assert.assertEquals("Позиций в вашей корзине: 1", positions);
    }

    @Test
    public void checkoutButton() {
        Assert.assertTrue(basketPage.clickCheckoutButton());
    }

    @Test
    public void removeProduct() {
        BasketPage removeButton = basketPage.clickRemoveButton();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        Assert.assertFalse(basketPage.clickCheckoutButton());
    }

    @Test
    public void selectQuantity() {
        BasketPage selectQuantity = basketPage.clickSelectQuantity();
        Assert.assertTrue(basketPage.clickCheckoutButton());
    }

    @Test
    public void removeAllProducts() {
        BasketPage removeAllProducts = basketPage.clickRemoveAllItemsButton();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        Assert.assertFalse(basketPage.clickCheckoutButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

