import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DermaESensitiveSkinCreamPageTest {
    private WebDriver driver;
    private DermaESensitiveSkinCreamPage dermaESensitiveSkinCreamPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        dermaESensitiveSkinCreamPage = new DermaESensitiveSkinCreamPage(driver);
        driver.get("https://ru.iherb.com/pr/Derma-E-Sensitive-Skin-Moisturizing-Cream-2-oz-56-g/6371");
    }

    @Test
    public void choosePackage(){
        DermaESensitiveSkinCreamPage twoOnceClick =dermaESensitiveSkinCreamPage.clickTwoOunceButton();
        DermaESensitiveSkinCreamPage add =dermaESensitiveSkinCreamPage.clickAddToCartButton();
        BasketPage basketPage = dermaESensitiveSkinCreamPage.clickBasketButton();
        String resultText= dermaESensitiveSkinCreamPage.getResultText();
        Assert.assertEquals("Позиций в вашей корзине: 2",resultText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
