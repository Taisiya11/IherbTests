import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class DermaEBrandPage {
    WebDriver driver;

    public DermaEBrandPage(WebDriver driver) {
        this.driver = driver;
    }

    private By beautyFilter = By.xpath("//li[@class='filter-links'][contains(.,'Увлажняющие средства для лица')]");
    private By ratingCheckbox = By.xpath("(//li[contains(@class,'filter-item')])[3]");
    private By priceCheckbox = By.xpath("//li[@class='filter-item'][contains(.,'₽2,000 - ₽3,000')]");
    private By smellDropDownOptions = By.xpath("//div[@class='filter-header-wrapper'][contains(.,'Запах')]");
    private By softSkinCheckbox = By.xpath("//li[@class='filter-item'][contains(.,'Нежная кожа')]");
    private By resultText = By.xpath("//span[@class='sub-header-title display-items']");
    private By sensitiveSkinCreamButton = By.xpath("//a[@class='absolute-link product-link']");


    public DermaEBrandPage clickBeautyFilter() {
        driver.findElement(beautyFilter).click();
        return this;
    }

    public DermaEBrandPage clickRatingCheckbox() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath(".//*[@class='icon welcome-mat-module-close']")).click();
            driver.findElement(ratingCheckbox).click();
            return this;
        }

        public DermaEBrandPage clickPriceCheckbox () {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            driver.findElement(priceCheckbox).click();
            return this;
        }

        public DermaEBrandPage clickSmellDropDownOptions () {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            driver.findElement(smellDropDownOptions).click();
            return this;
        }

        public DermaEBrandPage clickSoftSkinCheckbox () {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            driver.findElement(softSkinCheckbox).click();
            return this;
        }

        public DermaESensitiveSkinCreamPage clickSensitiveSkinCreamButton () {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            driver.findElement(sensitiveSkinCreamButton).click();
            return new DermaESensitiveSkinCreamPage(driver);
        }

    public String getResultText ()
    {
        return driver.findElement(resultText).getText();
    }

}
