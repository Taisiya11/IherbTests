import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    private By itemsInTheBasketText = By.xpath("//p[@class='ltr-8h912y']");
    private By searchBox = By.xpath("//input[@id='txtSearch']");
    private By searchButton = By.xpath("//button[@id='searchBtn']");
    private By addToCartFirstProduct = By.xpath("(//button[@name='AddToCart'])[1]");
    private By addToCartSecondProduct = By.xpath("(//button[@name='AddToCart'])[2]");
    private By headerCartButton = By.xpath("//div[@class='iherb-header-cart']");
    private By removeButton = By.xpath("(//a[@class='ltr-d63gxv'])[1]");
    private By selectQuantity  = By.xpath("//div[@class=' css-tlfecz-indicatorContainer']");
    private By threeProducts  = By.xpath("//div[@class=' css-26l3qy-menu']");


    public BasketPage typeDermaE(String product){
        driver.findElement(searchBox).sendKeys(product);
        return this;
    }
    public BasketPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }
    public BasketPage clickAddToCartButton(){
        driver.findElement(addToCartFirstProduct).click();
        return this;
    }
    public BasketPage clickAddToCartSecondProductButton(){
        driver.findElement(addToCartSecondProduct).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        return this;
    }
    public BasketPage clickHeaderCartButton(){
        driver.findElement(headerCartButton).click();
        return this;
    }
    public BasketPage clickRemoveButton(){
        driver.findElement(removeButton).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        return this;
    }
    public String getItemsInTheBasketText(){
        return driver.findElement(itemsInTheBasketText).getText();
    }
    public BasketPage clickSelectQuantity(){
        driver.findElement(selectQuantity).click();
        driver.findElement(threeProducts).click();
        return this;
    }

}
