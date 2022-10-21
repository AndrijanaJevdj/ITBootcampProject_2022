package demoBlaze.com.TestsDemoBlaze;

import demoBlaze.com.PagesDemoBlaze.Signup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSignup {
    private WebDriver webDriver;
    private Signup signUp;


    //region Before Method
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        signUp = new Signup(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //   webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();

    }
    //endregion



    //region Successful user registration
    @Test
    public void SignUpTest() throws InterruptedException {
        signUp.OpenSignUp();
        signUp.InputUsername();
        signUp.InputPassword();
        signUp.ClickOnSignUp();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        webDriver.switchTo().alert().accept();
        Assert.assertTrue(signUp.getSignUpButton().isDisplayed());
    }
    //endregion

    //region Unsuccessful user registration
    @Test
    public void BlankUsername(){
        signUp.OpenSignUp();
        signUp.InputPassword();
        signUp.ClickOnSignUp();
        Assert.assertTrue(true, "Username is blank");
        Assert.assertEquals(webDriver.switchTo().alert().getText().contains("Please fill out Username and Password."),true);


    }
    //endregion

    //region Successful termination of registration
    @Test
    public void CloseButton() throws InterruptedException {
        signUp.OpenSignUp();
        signUp.InputUsername();
        signUp.InputPassword();
        Thread.sleep(1000);
        Assert.assertTrue(signUp.getCloseButton().isDisplayed());
        signUp.ClickOnClose();
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.demoblaze.com/");

    }
    //endregion

    //region Exit registration
    @Test
    public void ExitRegistration(){
        signUp.OpenSignUp();
        signUp.ClickOnExit();
        Assert.assertTrue(signUp.getExitButton().isDisplayed());
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.demoblaze.com/");

    }
    //endregion



    //region Close web driver
    @AfterTest
    public void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
    }

    //endregion
}
