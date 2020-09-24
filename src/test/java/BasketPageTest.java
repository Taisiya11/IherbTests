import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasketPageTest {
    private WebDriver driver;
    private BasketPage basketPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        basketPage = new BasketPage(driver);
        driver.get("https://checkout4.iherb.com/cart");
    }

    @Test
    public void headerCart() {
        BasketPage searchBox = basketPage.typeDermaE("Derma E Sensitive Skin Moisturizing Cream");
        BasketPage searchButton =basketPage.clickSearchButton();
        driver.findElement(By.xpath(".//*[@class='icon welcome-mat-module-close']")).click();
        BasketPage addToCartFirstProduct =basketPage.clickAddToCartButton();
        basketPage.clickAddToCartButton();
        BasketPage addToCartSecondProduct =basketPage.clickAddToCartSecondProductButton();
        BasketPage headerCartButton =basketPage.clickHeaderCartButton();
        String positions1 = basketPage.getItemsInTheBasketText();
        Assert.assertEquals("3 items in your cart",positions1);
        BasketPage removeButton = basketPage.clickRemoveButton();
        String positions2 = basketPage.getItemsInTheBasketText();
        Assert.assertEquals("2 items in your cart",positions2);
        BasketPage selectQuantity = basketPage.clickSelectQuantity();
        String positions3 = basketPage.getItemsInTheBasketText();
        Assert.assertEquals("3 items in your cart",positions3);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

