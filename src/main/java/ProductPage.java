import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    private String dermaEBrandURL = "https://www.iherb.com/c/derma-e";
    private By cartButton = By.xpath(".//*[@class='icon icon-header-cart']");
    private By closeDropDownList = By.xpath(".//*[@class='icon welcome-mat-module-close']");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public ProductPage openPage() {
        driver.get(dermaEBrandURL);
        driver.findElement(closeDropDownList).click();
        return this;
    }

    public ProductPage clickAddToCartButton(int numberProduct) {
        By addToCartButton = By.xpath(String.format("(//button[@name='AddToCart'])[%d]", numberProduct));
        wait.until(driver -> ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        waitResponse();
        return this;
    }

    /* Я пока не разобралась как правильно дожидаться, когда запрос дойдет до сервера :( */
    private void waitResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ProductPage clickCartButton() {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(cartButton));
        driver.findElement(cartButton).click();
        return this;
    }
}
