import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CartPageTest {
    private WebDriver driver;
    private CartPage cartPage;
    private ProductPage productPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Таисия\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    void addProducts(int count) {
        productPage
                .openPage();
        for (int i = 0; i < count; i++){
            productPage.clickAddToCartButton(i + 1);
        driver.findElement(By.xpath("//i[@class='icon-exit close']")).click();}
        productPage.clickCartButton();
    }
    @Test
    public void quantityItems() {
        int startProductsCount=2;
        addProducts(startProductsCount);
        String positions = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+startProductsCount, positions);
        int addedProductsCount=3;
        cartPage.clickSelectQuantity(addedProductsCount);
        String positions2 = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+(startProductsCount+addedProductsCount), positions2);
        cartPage.clickRemoveAllItemsButton();
        String positions3 = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Корзина", positions3);
        Assert.assertFalse(cartPage.tryToClickCheckoutButton());
    }

    @Test
    public void removeProduct() {
        int startProductsCount=4;
        addProducts(startProductsCount);
        String positions = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+startProductsCount, positions);
        cartPage.clickRemoveButton();
        String positions2 = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+(startProductsCount-1), positions2);
        cartPage.clickRemoveButton();
        String positions3 = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+(startProductsCount-2), positions3);
        Assert.assertTrue(cartPage.tryToClickCheckoutButton());
    }

    @Test
    public void selectQuantity() {
        int startProductsCount = 2;
        int quantity=3;
        addProducts(startProductsCount);
        cartPage.clickSelectQuantity(quantity);
        String positions = cartPage.getItemsInTheCartText();
        Assert.assertEquals("Позиций в вашей корзине: "+(quantity+startProductsCount), positions);
        Assert.assertTrue(cartPage.tryToClickCheckoutButton());
    }

    @Test
    public void removeAllProducts() {
        addProducts(2);
        cartPage.clickRemoveAllItemsButton();
        Assert.assertFalse(cartPage.tryToClickCheckoutButton());
    }

    float parsePrice(String price) {
        return Float.parseFloat(price.replace(",","").substring(1));
    }

    @Test
    public void sumProducts() {
        addProducts(2);
        float sum = parsePrice(cartPage.getPrice(1)) + parsePrice(cartPage.getPrice(2));
        float sumTotal = parsePrice(cartPage.getTotalPrice());
        Assert.assertEquals(sum, sumTotal, 0.00001);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

