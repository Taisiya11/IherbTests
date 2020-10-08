import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BasketPage {
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartButton = By.xpath("//button[@name='AddToCart']");
    private By basketButton = By.xpath(".//*[@class='icon icon-header-cart']");
    private By checkoutButton = By.xpath("//a[@class='ltr-xt7vrb']");
    private By removeAllItemsButton = By.xpath("//span[@class='ltr-s3gz7q']");
    private By yesButton = By.xpath("//a[@class='ltr-yh684v']");
    private By itemsInTheBasketText = By.xpath("//p[@class='ltr-8h912y']");
    private By removeButton = By.xpath("(//a[@class='ltr-d63gxv'])[1]");
    private By selectQuantity = By.xpath("//div[@class=' css-tlfecz-indicatorContainer']");
    private By threeProducts = By.xpath("//div[@class=' css-26l3qy-menu']");


    public BasketPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public BasketPage clickBasketButton() {
        driver.findElement(basketButton).click();
        return new BasketPage(driver);
    }

    public BasketPage clickRemoveButton() {
        driver.findElement(removeButton).click();
        return this;
    }

    public BasketPage clickRemoveAllItemsButton() {
        driver.findElement(removeAllItemsButton).click();
        driver.findElement(yesButton).click();
        return this;
    }

    public boolean clickCheckoutButton() {
        try {
            driver.findElement(checkoutButton).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getItemsInTheBasketText() {
        return driver.findElement(itemsInTheBasketText).getText();
    }

    public BasketPage clickSelectQuantity() {
        driver.findElement(selectQuantity).click();
        driver.findElement(threeProducts).click();
        return this;
    }
}
