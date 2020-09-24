import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath(".//*[@class='sub-header-title']");
    private By brandDropDownOptions = By.xpath("//div[@class='menu-dropdown brands-menu']");
    private By dermaEBrandLink = By.xpath("//div[@class='type-default']/a[normalize-space()='Derma E']");

    public MainPage clickBrandDropDownOptions(){
        driver.findElement(brandDropDownOptions).click();
        return this;
    }

    public DermaEBrandPage clickDermaEBrandPage(){
        driver.findElement(dermaEBrandLink).click();
        return new DermaEBrandPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

}
