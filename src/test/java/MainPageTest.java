import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
   private WebDriver driver;
   private MainPage mainPage;

   @Before
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\Downloads\\chromedriver_win32\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       mainPage = new MainPage(driver);
       driver.get("https://ru.iherb.com/");
   }

   @Test
   public void chooseBrand(){
       MainPage brandDropDownOptions = mainPage.clickBrandDropDownOptions();
       DermaEBrandPage dermaEBrandPage = mainPage.clickDermaEBrandPage();
       String resultText= mainPage.getHeadingText();
       Assert.assertEquals("Derma E",resultText);
   }

   @After
    public void tearDown(){
       driver.quit();
   }
}
