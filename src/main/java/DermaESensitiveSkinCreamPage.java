import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DermaESensitiveSkinCreamPage {
    WebDriver driver;

    public DermaESensitiveSkinCreamPage(WebDriver driver) {
        this.driver = driver;
    }

    private By twoOunceButton = By.xpath("//div[@class='attribute-tile volume-grouping combo-shaded stock-onsale']");
    private By addToCartButton = By.xpath("//button[@name='AddToCart']");
    private By basketButton = By.xpath(".//*[@class='icon icon-header-cart']");
    private By resultText = By.xpath("//p[@class='ltr-8h912y']");

    public DermaESensitiveSkinCreamPage clickTwoOunceButton(){
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath(".//*[@class='icon welcome-mat-module-close']")).click();
        driver.findElement(twoOunceButton).click();
        return this;
    }

    public DermaESensitiveSkinCreamPage clickAddToCartButton(){
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        driver.findElement(addToCartButton).click();
        return this;
    }

    public BasketPage clickBasketButton(){
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        driver.findElement(basketButton).click();
        return new BasketPage(driver);
    }
    public String getResultText ()
    {
        return driver.findElement(resultText).getText();
    }
}