//import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://ru.iherb.com/");

//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        System.setProperty("webdriver.chrome.driver","path/to/driver/exe");
//        WebDriver driver =new ChromeDriver(options);

    }

}
