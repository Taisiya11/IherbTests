import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    private By checkoutButton = By.xpath("//a[@class='ltr-xt7vrb']");
    private By removeAllItemsButton = By.xpath("//span[@class='ltr-s3gz7q']");
    private By yesButton = By.xpath("//a[@class='ltr-yh684v']");
    private By itemsInTheCartText = By.xpath("//p[@class='ltr-8h912y']");
    private By removeButton = By.xpath("(//a[@class='ltr-d63gxv'])[1]");
    private By selectQuantity = By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]");
    private String threeProducts = "//div[@id='react-select-2-option-%d']";
    private By totalPriceOnThePage = By.xpath("(//div[@class='ltr-7v2edd'])[2]");
    private String productPriceXpath = "(//div[@class='ltr-17rm9tq'])[%d]";


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }


    public CartPage clickRemoveButton() {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(removeButton));
        driver.findElement(removeButton).click();
        return this;
    }

    public CartPage clickRemoveAllItemsButton() {
        driver.findElement(removeAllItemsButton).click();
        driver.findElement(yesButton).click();
        return this;
    }

    public boolean tryToClickCheckoutButton() {
        try {
            wait.until(driver -> ExpectedConditions.elementToBeClickable(checkoutButton));
            driver.findElement(checkoutButton).click();
            return true;
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    public String getItemsInTheCartText() {
        waitResponse();
        return driver.findElement(itemsInTheCartText).getText();

    }

    public CartPage clickSelectQuantity(int index) {
        By elementXPath = By.xpath(String.format(threeProducts, index));
        driver.findElement(selectQuantity).click();
        driver.findElement(elementXPath).click();
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

    // Индексы начинаются с 1.
    public String getPrice(int index) {
        By elementXPath = By.xpath(String.format(productPriceXpath, index));
        return driver.findElement(elementXPath).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPriceOnThePage).getText();
    }
}
