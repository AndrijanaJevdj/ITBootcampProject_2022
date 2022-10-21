package demoBlaze.com.TestsDemoBlaze;

import demoBlaze.com.PagesDemoBlaze.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMainPage {
    private WebDriver webDriver;
    private MainPage mainPage;
    private Actions actions;

    //region Before Method
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        actions = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //   webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();

    }
    //endregion


    //region Page url checker
    @Test
    public void UrlHomePage(){
        mainPage.ClickOnHome();
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.demoblaze.com/index.html" );

    }
    //endregion

    // region Page refresh
    @Test
    public void ReloadPage(){
        webDriver.get("https://www.demoblaze.com/");
        webDriver.navigate().refresh();
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.demoblaze.com/");
    }
    //endregion

    //region Successfully added product to cart
    @Test
    public void testAddToCart() throws InterruptedException {
        mainPage.moveToPhone();
        Assert.assertTrue(mainPage.getPhone().isDisplayed());
        mainPage.OpenPhone();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(mainPage.getAddToCart().isDisplayed());
        mainPage.ClickAddToCart();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.switchTo().alert().getText().equals("Product added"));
        webDriver.switchTo().alert().accept();



    }
    //endregion

    //region Contact Us
    @Test
    public void ContactUs() throws InterruptedException {
        mainPage.OpenContactUs();
        Assert.assertTrue(mainPage.getContactUs().isDisplayed());
        mainPage.InputContactEmail();
        Assert.assertTrue(mainPage.getContactEmail().isDisplayed());
        mainPage.InputContactName();
        Assert.assertTrue(mainPage.getContactName().isDisplayed());
        mainPage.InputContactMessage();
        Assert.assertTrue(mainPage.getSendMessage().isDisplayed());
        mainPage.ClickSendMessage();
        Thread.sleep(2000);
        Assert.assertTrue(webDriver.switchTo().alert().getText().equals("Thanks for the message!!"));
        webDriver.switchTo().alert().accept();

    }

    //endregion

    //region Open about us,play video and close about us
    @Test
    public void OpenAboutUs(){
        mainPage.OpenAboutUs();
        mainPage.PlayVideo();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.PauseVideo();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(mainPage.getCloseAboutUsButton().isDisplayed());
        mainPage.CloseAboutUs();

    }

    //endregion

    //region Click the logo button and wait for it to refresh the page
    @Test
    public void ClickTheLogoButton() throws InterruptedException {
        Thread.sleep(2000);
        mainPage.LogoButton();
        Assert.assertTrue(mainPage.getLogoButton().isDisplayed());
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.demoblaze.com/index.html" );
    }

    //endregion

    //region scroll the images three times to the right and check the displayed image
    @Test
    public void SlideImages(){
        mainPage.ClickOnRightButtonForSlidePictures();
        mainPage.ClickOnRightButtonForSlidePictures();
        mainPage.ClickOnRightButtonForSlidePictures();
        WebElement image = webDriver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/img[1]"));
        Assert.assertTrue(image.isDisplayed(),"Other image is displayed");
    }
    //endregion

    //region scroll the images one time to the left and check the displayed image
    @Test
    public void ClickLeftButton() throws InterruptedException {
        WebElement image = webDriver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/img[1]"));
        Thread.sleep(1000);
        mainPage.ClickOnLeftButtonForSlidePictures();
        Assert.assertTrue(image.isDisplayed(), "Other picture is displayed and the button doesn't work! ");
    }
    //endregion


    //region Close web driver
    @AfterTest
    public void closeWebDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.close();
    }

    //endregion

}
