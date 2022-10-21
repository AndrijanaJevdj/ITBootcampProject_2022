package demoBlaze.com.TestsDemoBlaze;
import demoBlaze.com.PagesDemoBlaze.Cart;
import demoBlaze.com.PagesDemoBlaze.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCart {

    private WebDriver webDriver;
    private Cart cart;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        cart = new Cart(webDriver);
        mainPage = new MainPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //   webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();

    }


    //region Open cart
    @Test
    public void OpenCartTest(){
        cart.OpenCart();
    }
    //endregion

    //region Checking the payment amount
    @Test
    public void CheckinPaymentAmount() throws InterruptedException {
        mainPage.moveToPhone();
        mainPage.OpenPhone();
        mainPage.ClickAddToCart();
        Thread.sleep(1000);
        webDriver.switchTo().alert().accept();
        cart.OpenCart2();
        cart.PriceVisible();
        cart.TotalPriceVisible();
        if (cart.getPrice().getText().equals(cart.getTotalP().getText())){
            System.out.println("Total price is ok!");
        }
    }
    //endregion

    //region Close web driver
    @AfterTest
    public void closeWebDriver() {
        webDriver.close();
    }
    //endregion

}



