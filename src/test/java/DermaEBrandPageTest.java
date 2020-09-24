import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DermaEBrandPageTest {
    private WebDriver driver;
    private DermaEBrandPage dermaEBrandPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        dermaEBrandPage = new DermaEBrandPage(driver);
        driver.get("https://ru.iherb.com/c/derma-e");
    }

    @Test
    public void selectFilter() {
        DermaEBrandPage beautyFilter = dermaEBrandPage.clickBeautyFilter();
        DermaEBrandPage ratingCheckbox = dermaEBrandPage.clickRatingCheckbox();
        DermaEBrandPage priceCheckbox = dermaEBrandPage.clickPriceCheckbox();
        DermaEBrandPage smellDropDownOptions = dermaEBrandPage.clickSmellDropDownOptions();
        DermaEBrandPage softSkinCheckbox = dermaEBrandPage.clickSoftSkinCheckbox();
        DermaESensitiveSkinCreamPage dermaESensitiveSkinCreamPage = dermaEBrandPage.clickSensitiveSkinCreamButton();
        String resultText= dermaEBrandPage.getResultText();
        Assert.assertEquals("Результатов: 1 (показано 1 - 1)",resultText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    }
